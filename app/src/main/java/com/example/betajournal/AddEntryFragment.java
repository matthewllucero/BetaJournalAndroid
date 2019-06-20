package com.example.betajournal;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Class created for the AddEntryFragment Fragment in the Navigation Graph
 * EntriesFragment -> AddEntryFragment -> ...
 */
public class AddEntryFragment extends Fragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private TextView chosenDate;
    private Calendar calendar;
    private DatePickerDialog dpd;
    private String chosenGrade;
    private int currentButton;
    private View mView;
    private GridLayout ongightGL;
    private GridLayout flashGL;
    private GridLayout redpointGL;
    private GridLayout noSendGL;
    private String date;
    private String location;
    private String onsight;
    private String flash;
    private String redpoint;
    private String noSend;

    public AddEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_entry, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        date = "";
        location = "";
        onsight = "";
        flash = "";
        redpoint = "";
        noSend = "";

        mView = view;
        ongightGL = view.findViewById(R.id.onsight_grid_layout);
        flashGL = view.findViewById(R.id.flash_grid_layout);
        redpointGL = view.findViewById(R.id.redpoint_grid_layout);
        noSendGL = view.findViewById(R.id.no_send_grid_layout);

        //Creating OnClickListener for the "Add" buttons and the "Save ExampleSavedEntry" button
        view.findViewById(R.id.add_onsight_btn).setOnClickListener(this);
        view.findViewById(R.id.add_flash_btn).setOnClickListener(this);
        view.findViewById(R.id.add_redpoint_btn).setOnClickListener(this);
        view.findViewById(R.id.no_send_btn).setOnClickListener(this);
        view.findViewById(R.id.save_entry_btn).setOnClickListener(this);

        //TextView created in fragment_add_entry.xml to display the user's chosen date
        chosenDate = (TextView) view.findViewById(R.id.date_text_view);

        //OnClickListener() created the the "Set Date" button
        view.findViewById(R.id.set_date_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int year = calendar.get(Calendar.YEAR);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {

                        //Grabs the current date chosen by the user and puts it into a string to be set in the chosenDate TextField
                        String mDate = mMonth + "/" + mDayOfMonth + "/" + mYear;

                        //Date needed for database
                        date = mDate;

                        chosenDate.setText(mDate);
                    }
                }, year, month, day);

                dpd.show();

            }
        });

    }


    @Override
    public void onClick(View v) {

        //Creates popup menu and uses the menu with the climbing grades
        PopupMenu popup = new PopupMenu(getActivity(), v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.climbing_grades);

        //Checks to see what button gets pressed (for later use)
        //the menu will show() when it hits certain buttons
        switch (v.getId()) {
            case R.id.add_onsight_btn:
                popup.show();
                System.out.println("onsight");
                currentButton = R.id.add_onsight_btn;
                break;
            case R.id.add_flash_btn:
                popup.show();
                System.out.println("flash");
                currentButton = R.id.add_flash_btn;
                break;
            case R.id.add_redpoint_btn:
                popup.show();
                System.out.println("redpoint");
                currentButton = R.id.add_redpoint_btn;
                break;
            case R.id.no_send_btn:
                popup.show();
                System.out.println("no send");
                currentButton = R.id.no_send_btn;
                break;
            case R.id.save_entry_btn:
                System.out.println("save");
                currentButton = R.id.save_entry_btn;
                saveEntry();
                break;
            default:
                currentButton = 0;
                break;
        }
    }

    /**
     * onMenuItemClick() is needed when we implemented PopupMenu.OnMenuItemClickListener
     * It will store the text of the item that was clicked
     * Passes that string to checkCurrentButton()
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        chosenGrade = item.getTitle().toString();
        checkCurrentButton(chosenGrade, currentButton);
        return false;
    }

    /**
     * Checks to see what the currentButton is that was set in the onClick() function.
     * This check is needed to add the current grade that was selected to the proper GridLayout
     */
    private void checkCurrentButton(String mCurrentGrade, int mCurrentButton) {
        switch (mCurrentButton) {
            case R.id.add_onsight_btn:
                addGradeToGridLayout(mCurrentGrade, ongightGL);
                break;
            case R.id.add_flash_btn:
                addGradeToGridLayout(mCurrentGrade, flashGL);
                break;
            case R.id.add_redpoint_btn:
                addGradeToGridLayout(mCurrentGrade, redpointGL);
                break;
            case R.id.no_send_btn:
                addGradeToGridLayout(mCurrentGrade, noSendGL);
                break;
            default:
                break;
        }
    }

    /**
     * addGradeToGridLayout() will first add whichever grade was chosen from the popupmenu
     * to the corresponding GridLayout that was passed in the checkCurrentButton() section
     */
    private void addGradeToGridLayout(String mCurrentGrade, GridLayout mGridLayout) {
        TextView tv = new TextView(getActivity());
        tv.setText(mCurrentGrade);
        mGridLayout.addView(tv);

        switch (currentButton) {
            case R.id.add_onsight_btn:
                onsight = onsight + mCurrentGrade + ", ";
                break;
            case R.id.add_flash_btn:
                flash = flash + mCurrentGrade + ", ";
                break;
            case R.id.add_redpoint_btn:
                redpoint = redpoint + mCurrentGrade + ", ";
                break;
            case R.id.no_send_btn:
                noSend = noSend + mCurrentGrade + ", ";
                break;
            default:
                break;
        }

    }


    /**
     * saveEntry() runs through the steps to add the proper strings to the database
     * once the user clicks the save button, the user will be directed to this function.
     */
    private void saveEntry() {
        if (date.isEmpty()) {
            Toast.makeText(getContext(), "Please enter date.", Toast.LENGTH_SHORT).show();
        } else {

            EditText locationTV = (EditText) mView.findViewById(R.id.location_edit_text);
            location = locationTV.getText().toString();

            String onsightSTR = onsight;
            String flashSTR = flash;
            String redpointSTR = redpoint;
            String noSendSTR = noSend;


            /*Since the Strings onsight, flash, redpoint, and noSend are concatenated with
              ", ", StringBuilder is used to removed the very last two characters which are
              ',' and ' '. That way in the EntriesFragment, the user can see their completed climbs
              in a nice comma-separated fashion.
            */
            if (!onsight.isEmpty()) {
                StringBuilder onsightSB = new StringBuilder(onsight);
                onsightSB.delete(onsightSB.length() - 2, onsightSB.length() - 1);
                onsightSTR = onsightSB.toString();
            }

            if (!flash.isEmpty()) {
                StringBuilder flashSB = new StringBuilder(flash);
                flashSB.delete(flashSB.length() - 2, flashSB.length() - 1);
                flashSTR = flashSB.toString();
            }

            if (!redpoint.isEmpty()) {
                StringBuilder redpointSB = new StringBuilder(redpoint);
                redpointSB.delete(redpointSB.length() - 2, redpointSB.length() - 1);
                redpointSTR = redpointSB.toString();
            }

            if (!noSend.isEmpty()) {
                StringBuilder noSendSB = new StringBuilder(noSend);
                noSendSB.delete(noSendSB.length() - 2, noSendSB.length() - 1);
                noSendSTR = noSendSB.toString();
            }

            //Creating a new instance of the SavedEntries class
            SavedEntries savedEntries = new SavedEntries();

            //Storing the proper values into the object of the SavedEntries class
            savedEntries.setDate(date);
            savedEntries.setLocation(location);
            savedEntries.setOnsight(onsightSTR);
            savedEntries.setFlash(flashSTR);
            savedEntries.setRedpoint(redpointSTR);
            savedEntries.setNoSend(noSendSTR);

            //Adding that object to the Room database
            MainActivity.myAppDatabase.myDao().addSavedEntry(savedEntries);
            Toast.makeText(getContext(), "Saved Entry", Toast.LENGTH_SHORT).show();


        }
    }
}
