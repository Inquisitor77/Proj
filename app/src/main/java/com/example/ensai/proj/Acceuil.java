package com.example.ensai.proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ensai.proj.Bdd.DAO;
import com.example.ensai.proj.Bdd.ListeContactsTel;
import com.example.ensai.proj.Elements.ContactTel;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO.initCompteur(this);

    }

    public void creer (View V){
        Intent intent = new Intent(Acceuil.this, AjoutPhase1.class);
        startActivity(intent);
    }

    public void test (View v){
        //méthode pour tester la liste de contact
       ArrayList<ContactTel> liste =  ListeContactsTel.listeContactsTel;
        Toast.makeText(this,liste.get(0).getNom() + " -> " + liste.get(0).getNumero(),Toast.LENGTH_LONG).show();

        //la méthode ne fonctionne pas sur émulateur car la liste de contact est vide (plantage OutOfBoundException car liste est vide)
    }
}
