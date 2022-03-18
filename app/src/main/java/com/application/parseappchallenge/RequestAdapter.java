package com.application.parseappchallenge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_request,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TODO
        ParseObject parseObject = requestObjects.get(position);

        holder.title.setText(parseObject.getString(Constants.TITLE_KEY));
        holder.creator.setText(parseObject.getString(Constants.CREATOR_KEY));
        holder.description.setText(parseObject.getString(Constants.DESCRIPTION_KEY));
        if(parseObject.getCreatedAt() != null){
            String dateTimeFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
                    .format(parseObject.getCreatedAt());
            holder.dateTime.setText(dateTimeFormat);
        }

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

        TextView title, description, creator, dateTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //TODO
            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            creator = itemView.findViewById(R.id.tv_creator);
            dateTime = itemView.findViewById(R.id.tv_date_time);
        }
    }
}
