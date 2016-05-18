package com.example.ensai.proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ensai.proj.Bdd.DAO;
import com.example.ensai.proj.Bdd.ListeContactsTel;
import com.example.ensai.proj.Elements.ContactTel;

import java.util.ArrayList;

public class SelectionContacts extends AppCompatActivity {

    Button bouton;
    ListView liste;
    Long idEvenement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_contacts);
        Intent intent = getIntent();
        idEvenement = intent.getLongExtra("idEvenement", -1);
        bouton = (Button) findViewById(R.id.boutonValid2);
        liste = (ListView) findViewById(R.id.listeContact);
        liste.setClickable(true);
        ArrayAdapter<ContactTel> adapter = new ArrayAdapter<ContactTel>(this,android.R.layout.simple_list_item_1,android.R.id.text1, ListeContactsTel.listeContactsTel);
        liste.setAdapter(adapter);


        for (int i =0; i<adapter.getCount();i++){
            for (int j = 0; j<ListeContactsTel.listeEvenementActif.size(); j++){
                if(adapter.getItem(i).getIdTel().equals( ListeContactsTel.listeEvenementActif.get(j).getIdTelephone())){
                  liste.setItemChecked(i,true);

                }
            }


        }

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(liste.isItemChecked(position)){
                    liste.setItemChecked(position,false);
                }else{
                    liste.setItemChecked(position,true);
                }
            }
        });


    }

    public void confirmerContacts(View v){
        ArrayList<ContactTel> newListe = new ArrayList<ContactTel>();
        DAO.renouvellerContacts(this,idEvenement);
    }

}
