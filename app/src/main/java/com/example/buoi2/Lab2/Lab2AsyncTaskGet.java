package com.example.buoi2.Lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab2AsyncTaskGet extends AsyncTask<String, Void, String> {
    private Context context;
    private String link, name, score;
    private TextView textView;
    private String kq = "";
    public Lab2AsyncTaskGet (Context context, String link, String name, String score, TextView textView){
        this.context = context;
        this.link = link;
        this.score = score;
        this.textView = textView;

    }
    @Override
    protected String doInBackground(String... strings) {
        link +="?name="+name+"&score="+score;
        try {
            URL url = new URL(link);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine())!=null){
              sb.append(line);
            }
            kq = sb.toString();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(kq);
    }
}
