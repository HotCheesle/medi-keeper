package com.example.medi_keeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText search_mname = findViewById(R.id.search_mname);

        Intent intent = getIntent();
        String searchtext = intent.getStringExtra("searchtext");
        search_mname.setText(searchtext);

    }
}