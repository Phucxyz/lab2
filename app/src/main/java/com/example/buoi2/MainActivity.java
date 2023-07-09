package com.example.buoi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buoi2.Lab2.Lab2Activity;
import com.example.buoi2.lab2bai2.Lab2bai2MainActivity;


public class MainActivity extends AppCompatActivity {

    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}

    public void Lab2(View view){
        Intent intent = new Intent(MainActivity.this, Lab2bai2MainActivity.class);
        startActivity(intent);
    }
}
