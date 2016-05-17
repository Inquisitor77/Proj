package com.example.ensai.proj.Metier;

import android.telephony.SmsManager;

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




}
