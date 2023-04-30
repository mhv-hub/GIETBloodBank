package com.unit.gietbloodbank;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity{

    EditText searchtv;
    Button srch;
    ListView list;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        list = (ListView) findViewById(R.id.list);
        searchtv = (EditText) findViewById(R.id.search);
        srch = (Button) findViewById(R.id.srch);

        db = openOrCreateDatabase("donor_details", Context.MODE_PRIVATE, null);

        arrayList = new ArrayList<String>();




        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = 0;
                if(searchtv.getText().toString().length()!=0)
                {
                    arrayList.clear();
                    Cursor c=db.rawQuery("SELECT * FROM donor_data", null);
                    while (c.moveToNext()) {
                        if (c.getString(0).equals(searchtv.getText().toString())) {
                                x++;
                                arrayList.add(c.getString(1));
                            }
                        }
                    if(x == 0){
                        arrayList.add("No Doners Available");
                    }
                    setAdapter();
                }
                else{
                    Toast.makeText(SearchActivity.this, "Enter a blood group to search", Toast.LENGTH_LONG).show();
                }
            }


        });
    }
    private void setAdapter() {
        adapter = new ArrayAdapter<String>(this,R.layout.listviewtext, arrayList);
        list.setAdapter(adapter);
    }
}
