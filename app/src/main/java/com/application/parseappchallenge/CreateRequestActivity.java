package com.application.parseappchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.contentcapture.ContentCaptureSession;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.application.parseappchallenge.databinding.ActivityCreateRequestBinding;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class CreateRequestActivity extends AppCompatActivity {

    ActivityCreateRequestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(v->{
            finish();
        });
        binding.btnPostRequest.setOnClickListener(v->{
            postRequest();
        });
        //TODO
    }

    private void postRequest() {
        String creator = binding.etCreator.getText().toString().trim();
        String title = binding.etTitle.getText().toString().trim();
        String description = binding.etDescription.getText().toString().trim();

        ParseObject request = new ParseObject(Constants.QUERY_KEY);
        request.put(Constants.CREATOR_KEY, creator);
        request.put(Constants.TITLE_KEY, title);
        request.put(Constants.DESCRIPTION_KEY, description);

        if(NetworkUtils.checkInternetConnection(this)){
            request.saveInBackground(e -> {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            });
        }else{
            Toast.makeText(this, getResources().getString(R.string.save_soon), Toast.LENGTH_SHORT).show();
            request.saveEventually();
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}
