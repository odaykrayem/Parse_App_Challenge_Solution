package com.application.parseappchallenge;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.application.parseappchallenge.databinding.ActivityMainBinding;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RequestAdapter requestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO: Add listener for "Create request" button and for swipe refresh layout

        //Initialize RecyclerView (view that shows list of all requests)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        requestAdapter = new RequestAdapter(new ArrayList<>());

        binding.recyclerView.setAdapter(requestAdapter);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        //Fetch list of requests
        fetchRequests();
    }

    /**
     *  Get list of requests from Parse database
     */
    public void fetchRequests() {
        //TODO: Check docs at http://docs.parseplatform.org/android/guide/#queries for how queries work
        ParseQuery<ParseObject> requestsQuery = ParseQuery.getQuery("Request");
    }
}