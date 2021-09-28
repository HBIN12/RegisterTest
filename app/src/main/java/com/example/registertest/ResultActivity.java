package com.example.registertest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView nameText,sexText,cityText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        nameText=findViewById(R.id.usernameresult);
        sexText=findViewById(R.id.sexresult);
        cityText=findViewById(R.id.cityresult);
        Intent intent=getIntent();
        if(intent!=null){
            nameText.setText(intent.getStringExtra("username"));
            sexText.setText(intent.getStringExtra("sex"));
            cityText.setText(intent.getStringExtra("city"));
        }
    }
}
