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
import android.widget.GridLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

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

        mView = view;
        ongightGL = view.findViewById(R.id.onsight_grid_layout);
        flashGL = view.findViewById(R.id.flash_grid_layout);
        redpointGL = view.findViewById(R.id.redpoint_grid_layout);
        noSendGL = view.findViewById(R.id.no_send_grid_layout);

        //Creating OnClickListener for the "Add" buttons and the "Save Entry" button
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
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int year = calendar.get(Calendar.YEAR);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {

                        //Grabs the current date chosen by the user and puts it into a string to be set in the chosenDate TextField
                        String date = mMonth + "/" + mDayOfMonth + "/" + mYear;
                        chosenDate.setText(date);
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
     *
     */
    private void addGradeToGridLayout(String mCurrentGrade, GridLayout mGridLayout) {
        TextView tv = new TextView(getActivity());
        tv.setText(mCurrentGrade);
        mGridLayout.addView(tv);
    }
}
