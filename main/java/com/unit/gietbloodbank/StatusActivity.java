package com.unit.gietbloodbank;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

public class StatusActivity extends AppCompatActivity {

    int aplus,aminus,bplus,bminus,abplus,abminus,oplus,ominus;
    TextView a1,a2,b1,b2,ab1,ab2,o1,o2;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_status);
        db = openOrCreateDatabase("donor_details", Context.MODE_PRIVATE, null);
        aplus=aminus=bplus=bminus=abplus=abminus=oplus=ominus = 0;

        a1 = (TextView) findViewById(R.id.aplus);
        a2 = (TextView) findViewById(R.id.aminus);
        b1 = (TextView) findViewById(R.id.bplus);
        b2 = (TextView) findViewById(R.id.bminus);
        ab1 = (TextView) findViewById(R.id.abplus);
        ab2 = (TextView) findViewById(R.id.abminus);
        o1 = (TextView) findViewById(R.id.oplus);
        o2 = (TextView) findViewById(R.id.ominus);

        Cursor c=db.rawQuery("SELECT * FROM donor_data", null);

        while (c.moveToNext()) {
                if (c.getString(0).equals("A+")) {
                    aplus++;
                }
                else if(c.getString(0).equals("A-")){
                    aminus++;
                }
                else if(c.getString(0).equals("B+")){
                    bplus++;
                }
                else if(c.getString(0).equals("B-")){
                    bminus++;
                }
                else if(c.getString(0).equals("AB+")){
                    abplus++;
                }
                else if(c.getString(0).equals("AB-")){
                    abminus++;
                }
                else if(c.getString(0).equals("O+")){
                    oplus++;
                }
                else if(c.getString(0).equals("O-")){
                    ominus++;
                }
        }

        a1.setText(Integer.toString(aplus*2));
        a2.setText(Integer.toString(aminus*2));
        b1.setText(Integer.toString(bplus*2));
        b2.setText(Integer.toString(bminus*2));
        ab1.setText(Integer.toString(abplus*2));
        ab2.setText(Integer.toString(abminus*2));
        o1.setText(Integer.toString(oplus*2));
        o2.setText(Integer.toString(ominus*2));



    }
}
