package com.e.upload_image;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Search_Location extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__location);
        getSupportActionBar().setTitle("Search_Location");
        button = findViewById(R.id.savebtn2);
        getSupportActionBar( ).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar( ).setDisplayShowHomeEnabled(true);//for back icon..


       button.setOnClickListener(new View.OnClickListener( ) {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),Upload_Images.class));
           }
       });
    }
}
