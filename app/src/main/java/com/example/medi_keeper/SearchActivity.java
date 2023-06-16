package com.example.medi_keeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import java.util.Objects;


public class SearchActivity extends AppCompatActivity {
    private android.support.v4.widget.DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);


        EditText search_mname = findViewById(R.id.search_mname);

        Intent intent = getIntent();
        String searchtext = intent.getStringExtra("searchtext");
        search_mname.setText(searchtext);

        RecyclerView searchview = findViewById(R.id.search_view);
        searchview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        Adapter adapter = new Adapter();
        for (int i = 0; i < 10; i++){
            String str = i + "번째 제목";
            adapter.setArrayData(str);
        }
    }
}

