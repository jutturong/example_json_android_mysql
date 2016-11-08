package com.example.linux.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

public class MainActivity extends Activity {

/*
    String strJSON = "[{\"MemberID\":\"1\",\"Name\":\"Weerachai\",\"Tel\":\"0819876107\"}" +
            ",{\"MemberID\":\"2\",\"Name\":\"Win\",\"Tel\":\"021978032\"}" +
            ",{\"MemberID\":\"3\",\"Name\":\"Eak\",\"Tel\":\"0876543210\"}]";

*/



    //[{"ImageID":"1","ImageName":"Image 1","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img1_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img1_full.jpg"},{"ImageID":"2","ImageName":"Image 2","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img2_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img2_full.jpg"},{"ImageID":"3","ImageName":"Image 3","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img3_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img3_full.jpg"},{"ImageID":"4","ImageName":"Image 4","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img4_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img4_full.jpg"},{"ImageID":"5","ImageName":"Image 5","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img5_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img5_full.jpg"},{"ImageID":"6","ImageName":"Image 6","ImagePath_Thumbnail":"http:\/\/www.thaicreate.com\/android\/img6_thum.jpg","ImagePath_FullPhoto":"http:\/\/www.thaicreate.com\/android\/img6_full.jpg"}]

    public String ip="http://10.87.196.170/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final ListView listView1=(ListView) findViewById(R.id.listView1);

        final Button btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


              /*
                try {
                    JSONArray data = new JSONArray(strJSON);

                    ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> map;

                    for(int i = 0; i < data.length(); i++){
                        JSONObject c = data.getJSONObject(i);


                        Toast.makeText(MainActivity.this,String.valueOf( c.getString("Name") ),Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                }
                */

                //http://localhost/json1.php
                //http://www.thaicreate.com/mobile/android-json-from-url.html


                String   url2 =  ip + "json1.php";
                 //http://192.168.2.112/dental/index.php/json/json1
                // public String ip="http://10.87.196.170/";

                //http://10.87.196.170/dental/index.php/json/json3/
               // String   url3 =  ip  + "dental/index.php/welcome/json_tb1/";
                String   url3 =  ip  + "dental/index.php/json/json3/";

                /*
                [{"CUSTOMER_ID":"C001","NAME":"Win Weerachai","EMAIL":"win.weerachai@thaicreate.com","COUNTRY_CODE":"TH","BUDGET":"1000000.00","USED":"600000.00"},{"CUSTOMER_ID":"C002","NAME":"John Smith","EMAIL":"john.smith@thaicreate.com","COUNTRY_CODE":"UK","BUDGET":"2000000.00","USED":"800000.00"},{"CUSTOMER_ID":"C003","NAME":"Jame Born","EMAIL":"jame.born@thaicreate.com","COUNTRY_CODE":"US","BUDGET":"3000000.00","USED":"600000.00"},{"CUSTOMER_ID":"C004","NAME":"Chalee Angel","EMAIL":"chalee.angel@thaicreate.com","COUNTRY_CODE":"US","BUDGET":"4000000.00","USED":"100000.00"}]
                 */


                try {
                    JSONArray data = new JSONArray(getJSONUrl(url3));


                    final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> map;


                    for(int i = 0; i < data.length(); i++){
                        JSONObject c = data.getJSONObject(i);

                      //  Toast.makeText(MainActivity.this,String.valueOf( c.getString("Name") ),Toast.LENGTH_SHORT).show();

                        //CUSTOMER_ID
                        //NAME
                        //EMAIL
                        //COUNTRY_CODE
                        //BUDGET
                        //USED


                        map = new HashMap<String, String>();
                        map.put("CUSTOMER_ID", c.getString("CUSTOMER_ID"));
                        map.put("NAME", c.getString("NAME"));
                        map.put("EMAIL", c.getString("EMAIL"));
                        map.put("COUNTRY_CODE", c.getString("COUNTRY_CODE"));
                        map.put("BUDGET", c.getString("BUDGET"));
                        map.put("USED", c.getString("USED"));
                        MyArrList.add(map);


                        Toast.makeText(MainActivity.this,String.valueOf(  c.getString("CUSTOMER_ID")  +   "  "   +  c.getString("NAME")  ),Toast.LENGTH_SHORT).show();

                    }


                    SimpleAdapter sAdap;
                    sAdap = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.activity_column,
                            new String[] {"CUSTOMER_ID", "NAME", "EMAIL" , "COUNTRY_CODE" }, new int[] {R.id.Col_CUSTOMER_ID, R.id.Col_NAME, R.id.Col_EMAIL ,R.id.Col_COUNTRY_CODE});

                    listView1.setAdapter(sAdap);



                }catch (JSONException e) {
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
