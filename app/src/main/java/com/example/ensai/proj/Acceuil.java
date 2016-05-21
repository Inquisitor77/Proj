package com.example.ensai.proj;

import android.content.ContentResolver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ensai.proj.Bdd.DAO;
import com.example.ensai.proj.Bdd.ListeContactsTel;
import com.example.ensai.proj.Elements.*;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {

    ArrayList<Evenement> listeEvenements;
    ListView listeViewEvenements;
    ArrayAdapter<Evenement> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO.initCompteur(this);
        ContentResolver cr = getContentResolver();
        ListeContactsTel.chargementContactsTel(cr);
        listeEvenements = DAO.selectListeEvenement(this);
        listeViewEvenements = (ListView) findViewById(R.id.listeEven);
        adapter = new ArrayAdapter<Evenement>(this, android.R.layout.simple_list_item_1,android.R.id.text1,listeEvenements);
        listeViewEvenements.setAdapter(adapter);

        listeViewEvenements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intentEvenement = new Intent(Acceuil.this, EvenementGestion.class);
                intentEvenement.putExtra("idEvenement", listeEvenements.get(position).getIdEvenement());
                startActivity(intentEvenement);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        listeEvenements = DAO.selectListeEvenement(this);
        adapter.notifyDataSetChanged();

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
