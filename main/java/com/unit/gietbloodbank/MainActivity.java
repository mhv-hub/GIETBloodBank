package com.unit.gietbloodbank;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView Quote;
    int n;
    Random r;

    Button form,search,notice,status;
    String str[] = {"Share a little,Care a little-Donate Blood",
                    "Heroes come in all type and sizes",
                    "Every drop counts ! Donate blood today",
                    "The blood doner of today may be the recipient tommorow..!",
                    "Donate your blood for a reason. Let the reason to be life.",
                    "Donation of Blood means a few minutes to you but a lifetime for somebody else.",
                    "The measure of life is not its duration, but its donation.",
                    "Your Droplets Of Blood May Create Ocean Of Happiness.",
                    "Blood is that fragile scarlet tree we carry within us",
                    "At 18 You Grow Up. At 18 You Drive. At 18 You Give Blood To Keep Someone Alive",
                    "Act as if what you do makes a difference. It does",
                    "Never Let mosquitoes get to your blood first",
                    "Nobody can do everything, but everyone can do something",
                    "Your blood can give someone second chance to live life",
                    "Blood donation is an ethical act which you must involve.",
                    "Don’t let someone to die, donate blood and save life",
                    "You are Rock Star of someone’s life, donate blood!"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Quote = (TextView) findViewById(R.id.quote);
        form = (Button) findViewById(R.id.form);
        search = (Button) findViewById(R.id.search);
        status = (Button) findViewById(R.id.status);
        notice = (Button) findViewById(R.id.notice);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormActivity.class);
                startActivity(i);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,StatusActivity.class);
                startActivity(i);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,NoticeActivity.class);
                startActivity(i);
            }
        });

        r = new Random();
        n = r.nextInt(17);
        Quote.setText(str[n]);

        Quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = r.nextInt(17);
                Quote.setText(str[n]);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater myMenu = getMenuInflater();
        myMenu.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.about:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                break;
        }
        return false;
    }
}
