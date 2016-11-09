package com.example.linux.myapplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public  String  url="http://192.168.2.112/dental/index.php/json/tb_herb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        final ListView listView1=(ListView) findViewById(R.id.listView1);

        final Button btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    JSONArray data = new JSONArray(getJSONUrl(url));

                    //  Toast.makeText(MainActivity.this,String.valueOf(  data.length()  ),Toast.LENGTH_SHORT).show();

                    final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> map;


                    for(int i = 0; i < data.length(); i++){
                        JSONObject c = data.getJSONObject(i);


                        map = new HashMap<String, String>();
                        map.put("name", c.getString("name"));
                        map.put("name_sci", c.getString("name_sci"));
                        map.put("name_local", c.getString("name_local"));


                        MyArrList.add(map);



                       // Toast.makeText(MainActivity.this,String.valueOf(  c.getString("name") ),Toast.LENGTH_SHORT).show();

                    }

                    SimpleAdapter sAdap;

                    sAdap = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.activity_column,
                            new String[] {"name", "name_sci", }, new int[] {R.id.Col_name, R.id.Col_name_sci, });
                    listView1.setAdapter(sAdap);




                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });








    }


    public String getJSONUrl(String url) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }



}
