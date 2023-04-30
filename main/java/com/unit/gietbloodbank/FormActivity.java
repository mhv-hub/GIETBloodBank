package com.unit.gietbloodbank;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {



    EditText searchtv;
    Button srch;
    ListView list;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    EditText name,age,phno,id;
    Button submit;
    Spinner spinner1,bloodgrp;
    String[] genderstring = {"Male","Female"};
    String[] bloodgroups = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
    SQLiteDatabase db;

    String dname,dphno,did,dgender,dage,dbgroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_form);

        db = openOrCreateDatabase("donor_details", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS donor_data(bg VARCHAR(3),Nm VARCHAR(20), idno VARCHAR(20), ag VARCHAR(3),phn VARCHAR(15),gndr VARCHAR(10));");


        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        phno = (EditText) findViewById(R.id.phno);
        id = (EditText) findViewById(R.id.id);

        spinner1 = (Spinner) findViewById(R.id.gender);
        bloodgrp = (Spinner) findViewById(R.id.bloodgrp);
        submit = (Button) findViewById(R.id.submit);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbgroup=bloodgrp.getSelectedItem().toString();
                dgender=bloodgrp.getSelectedItem().toString();
                dname = name.getText().toString();
                dage = age.getText().toString();
                dphno = phno.getText().toString();
                did = id.getText().toString();

                if(dname.length()!=0&&dphno.length()!=0&&dage.length()!=0&&did.length()!=0)
                {
                    db.execSQL("INSERT INTO donor_data VALUES('"+dbgroup+"','"+dname+"','"+did+"','"+dage+"','"+dgender+"','"+dphno+"');");
                    Toast.makeText(FormActivity.this, "DETAILS SUBMITTED SUCCESSFUL", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(FormActivity.this, "FILL ALL THE DETAILS", Toast.LENGTH_LONG).show();
                }

                name.setText("");
                age.setText("");
                phno.setText("");
                id.setText("");

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spiner_item,genderstring);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.spiner_item,bloodgroups);
        spinner1.setAdapter(adapter);
        bloodgrp.setAdapter(adapter2);

    }



}
