package com.example.betajournal;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntriesFragment extends Fragment {

    private View mView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExampleSavedEntry> exampleSavedEntries;


    public EntriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entries, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mView = view;

        view.findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(mView).navigate(R.id.add_entry_action);
            }
        });

        exampleSavedEntries = new ArrayList<>();

        setUpRecyclerView();

        populateEntries();
    }

    public void setUpRecyclerView() {
        mRecyclerView = mView.findViewById(R.id.entries_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new ExampleAdapter(exampleSavedEntries);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void populateEntries() {

        List<SavedEntries> savedEntries = MainActivity.myAppDatabase.myDao().getSavedEntries();

        for (SavedEntries savedEntry : savedEntries) {

            String dateDB = savedEntry.getDate();
            String locationDB = savedEntry.getLocation();
            String onsightGradesDB = savedEntry.getOnsight();
            String flashGradesDB = savedEntry.getFlash();
            String redpointGradesDB = savedEntry.getRedpoint();
            String noSendGradesDB = savedEntry.getNoSend();

            exampleSavedEntries.add(new ExampleSavedEntry(locationDB, dateDB, onsightGradesDB, flashGradesDB, redpointGradesDB, noSendGradesDB));

        }

    }
}
