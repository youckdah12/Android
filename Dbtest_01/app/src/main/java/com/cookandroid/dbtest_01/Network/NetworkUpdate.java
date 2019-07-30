package com.cookandroid.dbtest_01.Network;

import android.os.AsyncTask;

import com.cookandroid.dbtest_01.Custom_Adapter;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUpdate extends AsyncTask<String,Void,String> {
    private URL Url;
    private String URL_Adress="http://192.168.0.25/testWeb/testDB3_update.jsp";
    private Custom_Adapter adapter;

    public NetworkUpdate(Custom_Adapter adapter){
        this.adapter=adapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String res="";
        try {
            Url = new URL(URL_Adress);
            HttpURLConnection conn = (HttpURLConnection) Url.openConnection();

            conn.setDefaultUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=EUC-KR");
            StringBuffer buffer = new StringBuffer();
            buffer.append("id").append("=").append(strings[0]);
            buffer.append("&name").append("=").append(strings[1]);
            buffer.append("&phone").append("=").append(strings[2]);
            buffer.append("&grade").append("=").append(strings[3]);

            OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "EUC-KR");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            StringBuilder builder = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "EUC-KR"));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line + "\n");

            }
            res = builder.toString();
        }catch (MalformedURLException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }

        return res;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        int res =0;
        try{
            res=JsonParser.getResultJson(s);

        }catch (JSONException e){
            e.printStackTrace();
        }
        if (res==0){

        }else{
            new NetworkGet(adapter).execute("");
        }
    }

}
