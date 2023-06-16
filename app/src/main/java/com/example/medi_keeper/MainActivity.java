package com.example.medi_keeper;


import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private
    android.support.v4.widget.DrawerLayout drawerLayout;
/*
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Bundle bun = msg.getData();
            String naverHtml = bun.getString("NAVER_HTML");

            naverHtml = naverHtml.replaceAll("<b>","");
            naverHtml = naverHtml.replaceAll("</b>","");
            naverHtml = naverHtml.replaceAll("&lt;", "<");
            naverHtml = naverHtml.replaceAll("&gt;", ">");
            naverHtml = naverHtml.replaceAll("&amp;", "&");

            try {
                JSONObject jsonObject = new JSONObject(naverHtml);

                JSONArray newsArray = jsonObject.getJSONArray("items");

                mlist.clear();

                for(int i = 0; i < newsArray.length(); i++)
                {
                    JSONObject newsObject = newsArray.getJSONObject(i);

                    NewsRecyclerItem item = new NewsRecyclerItem();

                    item.setTitle(newsObject.getString("title"));
                    item.setDescription(newsObject.getString("description"));
                    item.setLink(newsObject.getString("link"));


                    mlist.add(item);
                }

                Log.v("main mAdapter","notifyDataSetChanged 호출");
                mAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    };
    void SearchMedicine(String searchtext) {
        if (searchtext.equals("") && searchtext != null) {
            Toast.makeText(getApplicationContext(), "검색어를 입력해주세요.",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            new Thread() {
                @Override
                public void run() {

                    String clientId = "클라이언트 아이디";//애플리케이션 클라이언트 아이디값";
                    String clientSecret = "클라이언트 시크릿";//애플리케이션 클라이언트 시크릿값";
                    try {
                        String text = URLEncoder.encode(searchtext, "UTF-8");
                        String apiURL = "https://openapi.naver.com/v1/search/?query=" + text + "&display=20"; // json 결과
                        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
                        URL url = new URL(apiURL);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET");
                        con.setRequestProperty("X-Naver-Client-Id", clientId);
                        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                        int responseCode = con.getResponseCode();
                        BufferedReader br;
                        if (responseCode == 200) { // 정상 호출
                            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                        } else {  // 에러 발생
                            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                        }
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = br.readLine()) != null) {
                            response.append(inputLine);
                            response.append("\n");
                        }
                        br.close();

                        String naverHtml = response.toString();

                        Bundle bun = new Bundle();
                        bun.putString("NAVER_HTML", naverHtml);
                        Message msg = handler.obtainMessage();
                        msg.setData(bun);
                        handler.sendMessage(msg);

                        //testText.setText(response.toString());
                        //System.out.println(response.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
*/

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