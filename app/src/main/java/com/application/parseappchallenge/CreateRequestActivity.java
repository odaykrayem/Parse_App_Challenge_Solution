package com.application.parseappchallenge;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.application.parseappchallenge.databinding.ActivityCreateRequestBinding;

public class CreateRequestActivity extends AppCompatActivity {

    ActivityCreateRequestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO
    }
}
