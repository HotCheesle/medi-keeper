package com.example.medi_keeper;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private
    android.support.v4.widget.DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);



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