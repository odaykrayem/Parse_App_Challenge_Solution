package com.application.parseappchallenge;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseObject;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    private ArrayList<ParseObject> requestObjects;

    /**
     * Init adapter for request list
     * @param requestObjects List of requests
     */
    public RequestAdapter(ArrayList<ParseObject> requestObjects) {
        //TODO
        this.requestObjects = requestObjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TODO
    }

    @Override
    public int getItemCount() {
        //TODO
        return requestObjects.size();
    }

    /**
     * ViewHolder class for request item
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
        }
    }
}
