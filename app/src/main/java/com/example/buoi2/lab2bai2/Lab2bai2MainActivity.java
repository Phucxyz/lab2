package com.example.buoi2.lab2bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buoi2.R;

public class Lab2bai2MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRs;
    String link;
    EditText edtdai, edtrong;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2bai2_main);
        tvRs = findViewById(R.id.txt3);
        edtdai = findViewById(R.id.edtdai);
        edtrong= findViewById(R.id.edtrong);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String link = "http://192.168.0.102/API-L2-NKW/dientich_POST.php";
        AsyncTask_POST post = new AsyncTask_POST(this, edtdai.getText().toString(),
                edtrong.getText().toString(),"",tvRs);
        post.execute();
    }
}