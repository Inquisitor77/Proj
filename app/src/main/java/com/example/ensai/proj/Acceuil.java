package com.example.ensai.proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Acceuil extends AppCompatActivity {
//youle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void creer (View V){
        Intent intent = new Intent(Acceuil.this, AjoutPhase1.class);
        startActivity(intent);
    }
}
