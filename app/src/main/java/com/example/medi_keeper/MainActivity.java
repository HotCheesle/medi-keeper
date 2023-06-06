package com.example.medi_keeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private
    android.support.v4.widget.DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText search_mname = findViewById(R.id.search_mname);
        Button search_btn_frommain = findViewById(R.id.search_btn_frommain);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        search_btn_frommain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search_mname.getText() != null) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    String searchtext = search_mname.getText().toString();
                    intent.putExtra("searchtext", searchtext);
                    startActivities(new Intent[]{intent});
                }

                //SearchMedicine(String.valueOf(search_mname.getText()))
            }
        });

    }

    //@Override
    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(R.id.drawer_layout);

                break;
        }
    return super.onOptionsItemSelected(item);
    }



}