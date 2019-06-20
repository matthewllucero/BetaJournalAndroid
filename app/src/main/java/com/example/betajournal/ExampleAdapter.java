package com.example.betajournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleSavedEntry> mSavedEntriesList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        //TextViews corresponding to the TVs in example_saved_entry.xml
        public TextView mDate;
        public TextView mLocation;
        public TextView mOnsight;
        public TextView mFlash;
        public TextView mRedPoint;
        public TextView mNoSend;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.saved_date_tv);
            mLocation = itemView.findViewById(R.id.saved_location_tv);
            mOnsight = itemView.findViewById(R.id.saved_onsight_tv);
            mFlash = itemView.findViewById(R.id.saved_flash_tv);
            mRedPoint = itemView.findViewById(R.id.saved_redpoint_tv);
            mNoSend = itemView.findViewById(R.id.saved_no_send_tv);
        }
    }

    public ExampleAdapter(ArrayList<ExampleSavedEntry> savedEntriesList) {
        mSavedEntriesList = savedEntriesList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_saved_entry, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        ExampleSavedEntry currentEntry = mSavedEntriesList.get(position);

        holder.mDate.setText(currentEntry.getDate());
        holder.mLocation.setText(currentEntry.getLocation());
        holder.mOnsight.setText(currentEntry.getOnsightGrades());
        holder.mFlash.setText(currentEntry.getFlashGrades());
        holder.mRedPoint.setText(currentEntry.getRedpointGrades());
        holder.mNoSend.setText(currentEntry.getNoSendGrades());

    }

    @Override
    public int getItemCount() {
        return mSavedEntriesList.size();
    }
}
