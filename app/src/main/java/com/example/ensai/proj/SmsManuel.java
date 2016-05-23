package com.example.ensai.proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ensai.proj.Bdd.ListeContactsTel;
import com.example.ensai.proj.Elements.ContactTel;
import com.example.ensai.proj.Metier.Sms;

import java.util.ArrayList;

public class SmsManuel extends AppCompatActivity {

    EditText t;
    ArrayList<ContactTel> listeSortie = new ArrayList<ContactTel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_manuel);
        t = (EditText) findViewById(R.id.texteSms);
    }

    public void retour(View v){
        finish();
    }

    public void envoi(View v){



        if(t.getText().toString().isEmpty()){

            Toast.makeText(this, "Vous devez entrer un texte",Toast.LENGTH_LONG).show();

        }else {

            for (int i = 0; i < ListeContactsTel.listeEvenementActif.size(); i++) {
                for (int j = 0; j < ListeContactsTel.listeContactsTel.size(); j++) {
                    if (ListeContactsTel.listeEvenementActif.get(i).getIdTelephone().equals(ListeContactsTel.listeContactsTel.get(j).getIdTel())) {
                        ContactTel c = new ContactTel();
                        c.setNumero(ListeContactsTel.listeContactsTel.get(j).getNumero());
                        listeSortie.add(c);
                    }
                }
            }
        }

        new Thread(sms).start();
        finish();

    }

    Runnable sms = new Runnable() {
        public void run() {
            Sms.envoiSmsGroupe(listeSortie,t.getText().toString());
        }
    };

}
