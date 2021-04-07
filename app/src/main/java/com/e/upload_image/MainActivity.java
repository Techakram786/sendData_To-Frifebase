package com.e.upload_image;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar( ).setTitle("Home_Page");
        tabLayout = findViewById(R.id.myTab);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // viewPager=findViewById(R.id.viewpager);
        tabLayout.addTab(tabLayout.newTab( ).setText("Rent"));
        tabLayout.addTab(tabLayout.newTab( ).setText("Buy"));
        ////////////////////////////////
        FirebaseRecyclerOptions<DetailModel> options =
                new FirebaseRecyclerOptions.Builder<DetailModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("DetailModel"), DetailModel.class)
                        .build();

    }

    public void Owners_btn(View view) {
        startActivity(new Intent(this, Post_new_property.class));
        Log.e("Mainactivity", "main");
    }
}