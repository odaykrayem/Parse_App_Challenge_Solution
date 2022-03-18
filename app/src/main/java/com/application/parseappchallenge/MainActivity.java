package com.application.parseappchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.application.parseappchallenge.databinding.ActivityMainBinding;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_REQUEST = 1;
    private ActivityMainBinding binding;
    private RequestAdapter requestAdapter;
    private ArrayList<ParseObject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //TODO: Add listener for "Create request" button and for swipe refresh layout

        //Initialize RecyclerView (view that shows list of all requests)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        binding.recyclerView.setLayoutManager(linearLayoutManager);

        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchRequests();
            }
        });

        binding.swipeRefreshLayout.setColorSchemeResources(R.color.purple_200,
                R.color.purple_500,
                R.color.purple_700
        );

        binding.swipeRefreshLayout.setRefreshing(true);
        binding.createNewRequestButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateRequestActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_REQUEST);
        });
        //Fetch list of requests
        fetchRequests();
    }

    /**
     * Get list of requests from Parse database
     */
    public void fetchRequests() {
        if (NetworkUtils.checkInternetConnection(this)) {
            //TODO: Check docs at http://docs.parseplatform.org/android/guide/#queries for how queries work
            ParseQuery<ParseObject> requestsQuery = ParseQuery.getQuery(Constants.QUERY_KEY);
            requestsQuery.findInBackground((objectList, e) -> {
                if (e == null) {
                    list = (ArrayList<ParseObject>) objectList;
                    ParseObject.pinAllInBackground(Constants.QUERY_KEY, objectList);
                    requestAdapter = new RequestAdapter(list);
                    binding.recyclerView.setAdapter(requestAdapter);
                } else {
                    Log.d("Error", "Error: " + e.getMessage());
                }
                binding.swipeRefreshLayout.setRefreshing(false);
            });
        } else {
                ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.QUERY_KEY);
                query.fromLocalDatastore();
                query.orderByAscending("createdAt");
                query.findInBackground((newObjectList, e) -> {
                    if (e == null) {
                        ArrayList<ParseObject>newList = new ArrayList<>(newObjectList) ;
                        if(newList == null){
                            Toast.makeText(MainActivity.this, getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                            binding.swipeRefreshLayout.setRefreshing(false);
                        }else{
                            requestAdapter = new RequestAdapter(newList);
                            binding.recyclerView.setAdapter(requestAdapter);
                            Log.d("offline list", " Retrieved: " + newList.size());
                        }
                    } else {
                        Log.d("Error local retrieve", "Error: " + e.getMessage());
                    }
                    binding.swipeRefreshLayout.setRefreshing(false);
                });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_REQUEST && resultCode == RESULT_OK) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery(Constants.QUERY_KEY);
            query.orderByAscending("createdAt");
            query.findInBackground((newList, e) -> {
                list.add(newList.get(newList.size()-1));
                requestAdapter.notifyItemInserted(newList.size()-1);
                binding.recyclerView.smoothScrollToPosition(newList.size()-1);
            });
        }
    }
}