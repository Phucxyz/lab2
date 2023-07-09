
package com.example.buoi2.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buoi2.R;

public class Lab2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView txt2;
    String link;
    EditText edt1, edt2;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        txt2 = findViewById(R.id.txt2);
        link = "http://192.168.0.102/API-L2-NKW/std_GET.php";
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Lab2AsyncTaskGet lab2AsyncTaskGet = new Lab2AsyncTaskGet(this,
                link,edt1.getText().toString(), edt2.getText().toString(),txt2);
        lab2AsyncTaskGet.execute();
    }
}