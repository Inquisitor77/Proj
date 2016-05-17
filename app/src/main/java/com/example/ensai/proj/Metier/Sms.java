package com.example.ensai.proj.Metier;

import android.telephony.SmsManager;

import com.example.ensai.proj.Elements.ContactTel;

import java.util.ArrayList;

/**
 * Created by ensai on 17/05/16.
 */
public class Sms {

    public static boolean envoiSms(String numero, String texte){

        boolean envoi = false;

            if(numero.length()>= 8){

                SmsManager.getDefault().sendTextMessage(numero, null, texte, null, null);
                envoi = true;

            }
        return envoi;

    }



    public static ArrayList<ContactTel> envoiSmsGroupe(ArrayList<ContactTel> listeEnvoi, String texte){

        ArrayList<ContactTel> listeErreur = new ArrayList<ContactTel>();
        boolean validation;

        for (int i = 0;  i<listeEnvoi.size(); i++ ){
            validation = false;
            validation = envoiSms(listeEnvoi.get(i).getNumero(), texte);
            if (validation = false){
                listeErreur.add(listeEnvoi.get(i));
            }
        }

        return listeErreur;

    }




}
