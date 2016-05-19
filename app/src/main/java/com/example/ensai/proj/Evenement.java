package com.example.ensai.proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Evenement extends AppCompatActivity {

    Long idEvenement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        Intent intent = getIntent();
        idEvenement = intent.getLongExtra("idEvenement", -1);
    }
}
