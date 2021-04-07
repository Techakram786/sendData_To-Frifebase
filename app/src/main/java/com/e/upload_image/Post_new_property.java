package com.e.upload_image;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;


public class Post_new_property extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editText1, editText2, editText3, editText4;
    CountryCodePicker ccp;
    Spinner spinner1, spinner2, spinner3;
    RadioGroup radioGroup;
    RadioButton RentRadioButton, SaleRadioButton;
    Button savebtn2;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new_property);
        getSupportActionBar( ).setTitle("Post new Property");
        getSupportActionBar( ).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar( ).setDisplayShowHomeEnabled(true);//for back icon..
        databaseReference= FirebaseDatabase.getInstance().getReference("DetailModel");
        initView();
        //edit text id find..
       savebtn2.setOnClickListener(new View.OnClickListener( ) {
           @Override
           public void onClick(View view)
           {
            if (validation())
            {
                String id=databaseReference.push().getKey();
                DetailModel detailModel=new DetailModel(name,email,ph_no,area,spinnerBhk,spinnerCity,spinnerFlor,radiogrp);
// detail model constructor..

                //detailModel.setName(name);
               // detailModel.setEmail(email);
                databaseReference.child(id).setValue(detailModel);
                startActivity(new Intent(getApplicationContext(),Search_Location.class));
            }
           }
       });

    }

    private void initView()
    {
        editText1 = findViewById(R.id.detailName);
        editText2 = findViewById(R.id.detailEmail);
        editText3 = findViewById(R.id.detailphNo_);
        editText4 = findViewById(R.id.detailArea);
        ccp=findViewById(R.id.detail_Ccp1);
        //spinner id find..
        spinner1 = (Spinner) findViewById(R.id.Dtl_Spinner1);
        spinner2 = (Spinner) findViewById(R.id.Dtl_Spinner2);
        spinner3 = (Spinner) findViewById(R.id.Dtl_Spinner3);
        //radio btn id find..
        radioGroup=findViewById(R.id.radiogroup);
        RentRadioButton = (RadioButton) findViewById(R.id.detailR_btn1);
        SaleRadioButton = (RadioButton) findViewById(R.id.detailR_btn2);
        savebtn2 = findViewById(R.id.Dtl_save_btn2);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //validation for detail..
    private String name, email, ph_no, area, spinnerCity, spinnerFlor, spinnerBhk,radiogrp;

    private boolean validation() {
        name = editText1.getText( ).toString( );
        email = editText2.getText( ).toString( );
        ph_no = editText3.getText( ).toString( );

        area = editText4.getText( ).toString( );
        spinnerCity = spinner1.getSelectedItem( ).toString( );
        spinnerFlor = spinner2.getSelectedItem( ).toString( );
        spinnerBhk = spinner3.getSelectedItem( ).toString( );
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);
        radiogrp =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "please Enter Name", Toast.LENGTH_SHORT).show( );
            editText1.requestFocus( );
            return false;
        }  else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please Enter Email", Toast.LENGTH_SHORT).show( );
            editText2.requestFocus( );

            return false;
        } else if (TextUtils.isEmpty(ph_no)) {
            Toast.makeText(this, "please Enter Phone No.", Toast.LENGTH_SHORT).show( );
            editText3.requestFocus( );
            return false;
        } else if (TextUtils.isEmpty(area)) {
            Toast.makeText(this, "please Enter Area", Toast.LENGTH_SHORT).show( );
            editText4.requestFocus( );
            return false;
        }/* else if (TextUtils.isEmpty(spinnerCity)) {
            Toast.makeText(this, "please Enter City", Toast.LENGTH_SHORT).show( );
            spinner1.requestFocus( );
            return false;
        } else if (TextUtils.isEmpty(spinnerFlor)) {
            Toast.makeText(this, "please Enter Flore", Toast.LENGTH_SHORT).show( );
            spinner2.requestFocus( );
            return false;
        } else if (TextUtils.isEmpty(spinnerBhk)) {
            Toast.makeText(this, "please Enter City", Toast.LENGTH_SHORT).show( );
            spinner3.requestFocus( );
            return false;
        } */else if (radioGroup.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "please select Gender", Toast.LENGTH_SHORT).show( );
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(editText2.getText().toString()).matches())
              {

                 editText2.setError("Enter Valid Email");
                 return false;
             }
            else
            {
                return true;

            }
        }


}






