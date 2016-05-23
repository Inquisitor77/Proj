package com.example.ensai.proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ensai.proj.Bdd.DAO;
import com.example.ensai.proj.Elements.Evenement;

public class EvenementGestion extends AppCompatActivity {

    Long idEvenement;
    ListView liste;
    TextView texte1;
    TextView texte2;
    TextView texte3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        Intent intent = getIntent();
        idEvenement = intent.getLongExtra("idEvenement", -1);
        liste = (ListView) findViewById(R.id.listeGestion);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_list_item_1);
        liste.setAdapter(adapter);

        Evenement evenement = DAO.selectEvenement(this, idEvenement);
        texte1 = (TextView) findViewById(R.id.compl1);
        texte2 = (TextView) findViewById(R.id.compl2);
        texte3 = (TextView) findViewById(R.id.compl3);

        texte1.setText(evenement.getNom());
        texte2.setText(evenement.getmDay() + "/" + evenement.getmMonth() + "/" + evenement.getmYear() + "   " + evenement.getHeure() + ":" + evenement.getMinutes());
        texte3.setText(evenement.getDescription());


        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        //modification contacts
                        Intent intentContact = new Intent(EvenementGestion.this, SelectionContacts.class);
                        intentContact.putExtra("idEvenement", idEvenement);
                        startActivity(intentContact);
                        finish();
                        break;
                    case 1:
                        //envoi sms
                        Intent intentSms = new Intent(EvenementGestion.this, SmsManuel.class);
                        intentSms.putExtra("idEvenement", idEvenement);
                        startActivity(intentSms);
                        break;
                    case 2:
                        //fin evenement
                        DAO.terminerEvenementBdd(EvenementGestion.this,idEvenement);
                        finish();
                        break;
                    default:
                        Toast.makeText(EvenementGestion.this, R.string.probleme,Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    public void quitterEven(View v){
        finish();
    }
}

