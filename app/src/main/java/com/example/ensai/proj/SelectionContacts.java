package com.example.ensai.proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ensai.proj.Bdd.ListeContactsTel;
import com.example.ensai.proj.Elements.ContactTel;

public class SelectionContacts extends AppCompatActivity {

    Button bouton;
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_contacts);
        bouton = (Button) findViewById(R.id.boutonValid2);
        liste = (ListView) findViewById(R.id.listeContact);
        ArrayAdapter<ContactTel> adapter = new ArrayAdapter<ContactTel>(this,android.R.layout.simple_list_item_1,android.R.id.text1, ListeContactsTel.listeContactsTel);
        liste.setAdapter(adapter);


    }
}
