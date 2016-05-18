package com.example.ensai.proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Aide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);
    }

    public void retourAide(View v){
        finish();
    }
}
