package com.example.betajournal;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {

    private TextView v0Count, v1Count, v2Count, v3Count, v4Count, v5Count, v6Count, v7Count, v8Count,
            v9Count, v10Count, v11Count, v12Count, v13Count, v14Count, v15Count, v16Count;
    private TextView v0Bar, v1Bar, v2Bar, v3Bar, v4Bar, v5Bar, v6Bar, v7Bar, v8Bar, v9Bar, v10Bar, v11Bar,
        v12Bar, v13Bar, v14Bar, v15Bar, v16Bar;
    private View mView;
    private int v0 = 0, v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0, v8 = 0,
            v9 = 0, v10 = 0, v11 = 0, v12 = 0, v13 = 0, v14 = 0, v15 = 0, v16 = 0;

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mView = view;
        initialzeCountTextViews();
        initializeBarTextViews();
        getValuesFromDB();
        updateCount();
        updateBar();
        setBarColor();
        getMostClimbed();
        getHighestGrade();

    }

    private void initialzeCountTextViews() {
        v0Count = mView.findViewById(R.id.v0_count);
        v1Count = mView.findViewById(R.id.v1_count);
        v2Count = mView.findViewById(R.id.v2_count);
        v3Count = mView.findViewById(R.id.v3_count);
        v4Count = mView.findViewById(R.id.v4_count);
        v5Count = mView.findViewById(R.id.v5_count);
        v6Count = mView.findViewById(R.id.v6_count);
        v7Count = mView.findViewById(R.id.v7_count);
        v8Count = mView.findViewById(R.id.v8_count);
        v9Count = mView.findViewById(R.id.v9_count);
        v10Count = mView.findViewById(R.id.v10_count);
        v11Count = mView.findViewById(R.id.v11_count);
        v12Count = mView.findViewById(R.id.v12_count);
        v13Count = mView.findViewById(R.id.v13_count);
        v14Count = mView.findViewById(R.id.v14_count);
        v15Count = mView.findViewById(R.id.v15_count);
        v16Count = mView.findViewById(R.id.v16_count);
    }

    private void initializeBarTextViews() {
        v0Bar = mView.findViewById(R.id.v0_bar);
        v1Bar = mView.findViewById(R.id.v1_bar);
        v2Bar = mView.findViewById(R.id.v2_bar);
        v3Bar = mView.findViewById(R.id.v3_bar);
        v4Bar = mView.findViewById(R.id.v4_bar);
        v5Bar = mView.findViewById(R.id.v5_bar);
        v6Bar = mView.findViewById(R.id.v6_bar);
        v7Bar = mView.findViewById(R.id.v7_bar);
        v8Bar = mView.findViewById(R.id.v8_bar);
        v9Bar = mView.findViewById(R.id.v9_bar);
        v10Bar = mView.findViewById(R.id.v10_bar);
        v11Bar = mView.findViewById(R.id.v11_bar);
        v12Bar = mView.findViewById(R.id.v12_bar);
        v13Bar = mView.findViewById(R.id.v13_bar);
        v14Bar = mView.findViewById(R.id.v14_bar);
        v15Bar = mView.findViewById(R.id.v15_bar);
        v16Bar = mView.findViewById(R.id.v16_bar);
    }

    private void getValuesFromDB() {

        List<SavedEntries> savedEntries = MainActivity.myAppDatabase.myDao().getSavedEntries();

        for (SavedEntries savedEntry : savedEntries) {
            v0 += savedEntry.getV0Count();
            v1 += savedEntry.getV1Count();
            v2 += savedEntry.getV2Count();
            v3 += savedEntry.getV3Count();
            v4 += savedEntry.getV4Count();
            v5 += savedEntry.getV5Count();
            v6 += savedEntry.getV6Count();
            v7 += savedEntry.getV7Count();
            v8 += savedEntry.getV8Count();
            v9 += savedEntry.getV9Count();
            v10 += savedEntry.getV10Count();
            v11 += savedEntry.getV11Count();
            v12 += savedEntry.getV12Count();
            v13 += savedEntry.getV13count();
            v14 += savedEntry.getV14Count();
            v15 += savedEntry.getV15Count();
            v16 += savedEntry.getV16Count();

        }
    }

    private void updateCount() {
        v0Count.setText(String.valueOf(v0));
        v1Count.setText(String.valueOf(v1));
        v2Count.setText(String.valueOf(v2));
        v3Count.setText(String.valueOf(v3));
        v4Count.setText(String.valueOf(v4));
        v5Count.setText(String.valueOf(v5));
        v6Count.setText(String.valueOf(v6));
        v7Count.setText(String.valueOf(v7));
        v8Count.setText(String.valueOf(v8));
        v9Count.setText(String.valueOf(v9));
        v10Count.setText(String.valueOf(v10));
        v11Count.setText(String.valueOf(v11));
        v12Count.setText(String.valueOf(v12));
        v13Count.setText(String.valueOf(v13));
        v14Count.setText(String.valueOf(v14));
        v15Count.setText(String.valueOf(v15));
        v16Count.setText(String.valueOf(v16));
    }

    private void updateBar() {
        v0Bar.setHeight(v0 * 2 + 1);
        v1Bar.setHeight(v1 * 2 + 1);
        v2Bar.setHeight(v2 * 2 + 1);
        v3Bar.setHeight(v3 * 2 + 1);
        v4Bar.setHeight(v4 * 2 + 1);
        v5Bar.setHeight(v5 * 2 + 1);
        v6Bar.setHeight(v6 * 2 + 1);
        v7Bar.setHeight(v7 * 2 + 1);
        v8Bar.setHeight(v8 * 2 + 1);
        v9Bar.setHeight(v9 * 2 + 1);
        v10Bar.setHeight(v10 * 2 + 1);
        v11Bar.setHeight(v11 * 2 + 1);
        v12Bar.setHeight(v12 * 2 + 1);
        v13Bar.setHeight(v13 * 2 + 1);
        v14Bar.setHeight(v14 * 2 + 1);
        v15Bar.setHeight(v15 * 2 + 1);
        v16Bar.setHeight(v16 * 2 + 1);

    }

    private void setBarColor() {
        v0Bar.setBackgroundColor( getRandomColor() );
        v1Bar.setBackgroundColor( getRandomColor() );
        v2Bar.setBackgroundColor( getRandomColor() );
        v3Bar.setBackgroundColor( getRandomColor() );
        v4Bar.setBackgroundColor( getRandomColor() );
        v5Bar.setBackgroundColor( getRandomColor() );
        v6Bar.setBackgroundColor( getRandomColor() );
        v7Bar.setBackgroundColor( getRandomColor() );
        v8Bar.setBackgroundColor( getRandomColor() );
        v9Bar.setBackgroundColor( getRandomColor() );
        v10Bar.setBackgroundColor( getRandomColor() );
        v11Bar.setBackgroundColor( getRandomColor() );
        v12Bar.setBackgroundColor( getRandomColor() );
        v13Bar.setBackgroundColor( getRandomColor() );
        v14Bar.setBackgroundColor( getRandomColor() );
        v15Bar.setBackgroundColor( getRandomColor() );
        v16Bar.setBackgroundColor( getRandomColor() );

    }

    private int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    private void getMostClimbed() {
        int[] grades = {v0, v1, v2, v3, v4, v5, v6, v7, v8, v9,
                        v10, v11, v12, v13, v14, v15, v16};

        int max = 0;
        int maxGradeIndex = -1;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxGradeIndex = i;
            }
        }

        String grade = returnMostClimbedGrade(maxGradeIndex);
        TextView mostClimbed = mView.findViewById(R.id.most_climbed);
        String newText = "Most Climbed: " + grade;
        mostClimbed.setText(newText);

    }

    private String returnMostClimbedGrade(int index) {

        String grade;

        switch (index) {

            case 0:
                grade = "V0";
                break;
            case 1:
                grade = "V1";
                break;
            case 2:
                grade = "V2";
                break;
            case 3:
                grade = "V3";
                break;
            case 4:
                grade = "V4";
                break;
            case 5:
                grade = "V5";
                break;
            case 6:
                grade = "V6";
                break;
            case 7:
                grade = "V7";
                break;
            case 8:
                grade = "V8";
                break;
            case 9:
                grade = "V9";
                break;
            case 10:
                grade = "V10";
                break;
            case 11:
                grade = "V11";
                break;
            case 12:
                grade = "V12";
                break;
            case 13:
                grade = "V13";
                break;
            case 14:
                grade = "V14";
                break;
            case 15:
                grade = "V15";
                break;
            case 16:
                grade = "V16";
                break;
            default:
                grade = " ";
                break;
        }

        return grade;
    }

    private void getHighestGrade() {
        int[] grades = {v0, v1, v2, v3, v4, v5, v6, v7, v8, v9,
                v10, v11, v12, v13, v14, v15, v16};

        int highestGradeIndex = -1;

        for (int i = grades.length - 1; i >= 0; i--) {
            if (grades[i] > 0) {
                highestGradeIndex = i;
                break;
            }
        }

        String grade = returnMostClimbedGrade(highestGradeIndex);
        TextView highestGrade = mView.findViewById(R.id.highest_grade);
        String newText = "Highest Grade: " + grade;
        highestGrade.setText(newText);

    }
}
