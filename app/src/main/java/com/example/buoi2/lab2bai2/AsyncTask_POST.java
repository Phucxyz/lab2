package com.example.buoi2.lab2bai2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncTask_POST extends AsyncTask<Void,Void,Void> {
    private Context context;
    private String dai, rong, link;
    private String result="";
    private TextView tvRs;

    public AsyncTask_POST(Context context, String dai, String rong, String link, TextView tvRs){
        this.context = context;
        this.dai = link;
        this.rong = rong;
        this.tvRs = tvRs;
    }
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(link);
            String ts = "chieurong = "+ URLEncoder.encode (rong,"utf-8")+
                    "$chieudai="+URLEncoder.encode(dai,"utf-8");


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(ts.getBytes().length);
            urlConnection.setRequestProperty("Context-Type","application/x-www-form-urlencoded");
            PrintWriter p = new PrintWriter(urlConnection.getOutputStream());
            p.print(link);
            p.close();

            String line ="";
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
            result = sb.toString();
            urlConnection.disconnect();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        tvRs.setText(result);
    }
}
