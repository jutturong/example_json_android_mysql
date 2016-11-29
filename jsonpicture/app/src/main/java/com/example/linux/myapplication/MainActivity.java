package com.example.linux.myapplication;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends TabActivity {


    private static final String TAG = "ERROR";
    private static final int IO_BUFFER_SIZE = 4 * 1024;



    public  String  url="http://192.168.2.112/dental/index.php/json/tb_herb";

    public  String url_img1="http://192.168.2.112/dental/upload/35.jpg";

    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain", "Thailand", "Taiwan"
    };

    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        // autoCompleteTextView1
        final AutoCompleteTextView autocomplete1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        final  List<String> arrList = new ArrayList<String>();

         //--tab
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("INDEX").setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("SEARCh").setContent(R.id.tab2));


        mTabHost.setCurrentTab(0);


        final LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        final ListView listView1=(ListView) findViewById(R.id.listView1);


        final ImageView imageView1=(ImageView) findViewById(R.id.imageView1);
        // imageView1.setImageResource(R.drawable.bg_main);
        //  imageView1.setImageResource(R.drawable.test1);
        //imageView1.setImageResource(R.drawable.test2);


        
        final Button btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


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
                        map.put("general", c.getString("general"));
                        map.put("properties", c.getString("properties"));
                        map.put("usage", c.getString("usage"));

                        MyArrList.add(map);

                        arrList.add( c.getString("name") );
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_item,
                                arrList);
                        autocomplete1.setAdapter(adapter);

                       // Toast.makeText(MainActivity.this,String.valueOf(  c.getString("name") ),Toast.LENGTH_SHORT).show();

                    }

                    SimpleAdapter sAdap;





                    // String url = txt1.getText().toString();
                    try
                    {
                        imageView1.setImageBitmap(loadBitmap(url_img1));


                        sAdap = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.activity_column,
                                new String[] {"name", "properties", }, new int[] {R.id.Col_name, R.id.Col_name_sci,  });
                        listView1.setAdapter(sAdap);


                    } catch (Exception e) {
                        // When Error
                        imageView1.setImageResource(android.R.drawable.ic_menu_report_image);
                        Toast.makeText(MainActivity.this,"Load Image Failed.",
                                Toast.LENGTH_LONG).show();
                    }




                    final AlertDialog.Builder viewDetail = new AlertDialog.Builder(MainActivity.this);

                    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> myAdapter, View myView,
                                                int position, long mylng) {

                            String sname = MyArrList.get(position).get("name")
                                    .toString();

                            String name_sci = MyArrList.get(position).get("name_sci")
                                    .toString();

                            String name_local = MyArrList.get(position).get("name_local")
                                    .toString();

                            String general = MyArrList.get(position).get("general")
                                    .toString();

                            String properties = MyArrList.get(position).get("properties")
                                    .toString();

                            String usage = MyArrList.get(position).get("usage")
                                    .toString();






                            // Toast.makeText(MainActivity.this,String.valueOf(  sname ),Toast.LENGTH_SHORT).show();

                            viewDetail.setIcon(android.R.drawable.btn_minus);
                            viewDetail.setTitle("LOADING..");

                            viewDetail.setMessage(
                                    "ชื่อวิทยาศาสตร์ : " + name_sci + "\n" + "\n"
                                    + "ชื่อสามัญ : " + name_local + "\n" + "\n"
                                            + "ลักษณะทั่วไป : " + general + "\n" + "\n"
                                            + "สรรพคุณทางสมุนไพร : " + general + "\n"  + "\n"
                                            + "สรรพคุณเพิ่มเติม : " + usage + "\n" + "\n"
                                                 );

                            viewDetail.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            // TODO Auto-generated method stub
                                            dialog.dismiss();
                                        }
                                    });
                           // viewDetail.setView()

                            viewDetail.show();






                        }

                    });



                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });








    }


    public static Bitmap loadBitmap(String url) {
        Bitmap bitmap = null;
        InputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);

            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
            out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
            copy(in, out);
            out.flush();

            final byte[] data = dataStream.toByteArray();
            BitmapFactory.Options options = new BitmapFactory.Options();
            //options.inSampleSize = 1;

            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
        } catch (IOException e) {
            Log.e(TAG, "Could not load Bitmap from: " + url);
        } finally {
            closeStream(in);
            closeStream(out);
        }

        return bitmap;
    }


    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                android.util.Log.e(TAG, "Could not close stream", e);
            }
        }
    }


    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] b = new byte[IO_BUFFER_SIZE];
        int read;
        while ((read = in.read(b)) != -1) {
            out.write(b, 0, read);
        }
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
