package com.example.ensai.proj.Bdd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.ensai.proj.Elements.Contact;
import com.example.ensai.proj.Elements.Evenement;
import com.example.ensai.proj.Elements.SmsAuto;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ensai on 10/05/16.
 */
public class DAO {

    public static Long compteur = 0L;

    public static void initCompteur(Context context){

        Long val = 0L;

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        Cursor curseur = base.rawQuery("SELECT * FROM Evenement",
                new String[]{});

        int nblignes = curseur.getCount();
        while (curseur.moveToNext()){
            Long idEvenement = curseur.getLong(0);
            if (idEvenement>val){
                compteur = idEvenement;

            }

        }

        base.close();
        helper.close();



    }


    public static void insertEvenement(Context context, String nom, String description, int mYear, int mMonth, int mDay, int heure, int minutes){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO Evenement " +
                "(idEvenement, nom, description, mYear, mMonth, mDay, heure, minutes) VALUES(?,?,?,?,?,?,?,?)");
        compteur = compteur + 1L;
        rqt.bindLong(1,compteur);
        rqt.bindString(2,nom);
        rqt.bindString(3, description);
        rqt.bindLong(4, mYear);
        rqt.bindLong(5, mMonth);
        rqt.bindLong(6, mDay);
        rqt.bindLong(7, heure);
        rqt.bindLong(8, minutes);

        rqt.execute();
        base.close();
        helper.close();

    }



    /**
     * Méthode pour insérer un Contact en bdd
     *
     * @param context
     * @param idEvenement
     * @param idTelephone
     */

    public static void insertContact(Context context, long idEvenement, String  idTelephone){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO Contact " +
                "(idEvenement, idTelephone) VALUES(?,?)");
        rqt.bindLong(1, idEvenement);
        rqt.bindString(2, idTelephone);

        rqt.execute();
        base.close();
        helper.close();

    }


    public static void insertSmsAuto(Context context, Long idEvenement, String texte, int mYear, int mMonth, int mDay, int heure, int minutes){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO SmsAuto " +
                "(idEvenement, texte, mYear, mMonth, mDayn, heure, minutes) VALUES(?,?,?,?,?,?,?)");
        rqt.bindLong(1,idEvenement);
        rqt.bindString(2, texte);
        rqt.bindLong(3, mYear);
        rqt.bindLong(4, mMonth);
        rqt.bindLong(5, mDay);
        rqt.bindLong(6, heure);
        rqt.bindLong(7, minutes);

        rqt.execute();
        base.close();
        helper.close();

    }


    /**
     * Méthode pour récupérer la liste des evenements
     *
     * @param context
     * @return
     */
    public static ArrayList<Evenement> selectListeEvenement(Context context) {

        ArrayList<Evenement> liste = new ArrayList<Evenement>();

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        Cursor curseur = base.rawQuery("SELECT * FROM Evenement",
                new String[]{});

        int nblignes = curseur.getCount();
        while (curseur.moveToNext()){
            Long idEvenement = curseur.getLong(0);
            String nom = curseur.getString(1);
            String description = curseur.getString(2);
            int mYear = curseur.getInt(3);
            int mMonth = curseur.getInt(3);
            int mDay = curseur.getInt(3);
            int heure = curseur.getInt(3);
            int minutes = curseur.getInt(3);
            Evenement elem = new Evenement(idEvenement,nom,description,mYear,mMonth,mDay,heure,minutes);
            liste.add(elem);
        }

        base.close();
        helper.close();

        return liste;
    }


    public static Evenement selectEvenement(Context context,Long idEvenement) {

        Evenement even = new Evenement();

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        Cursor curseur = base.rawQuery("SELECT * FROM Evenement WHERE idEvenement =?",
                new String[]{idEvenement.toString()});

        int nblignes = curseur.getCount();
        while (curseur.moveToNext()){
            String nom = curseur.getString(1);
            String description = curseur.getString(2);
            int mYear = curseur.getInt(3);
            int mMonth = curseur.getInt(4);
            int mDay = curseur.getInt(5);
            int heure = curseur.getInt(6);
            int minutes = curseur.getInt(7);
            even = new Evenement(idEvenement,nom,description,mYear,mMonth,mDay,heure,minutes);
        }

        base.close();
        helper.close();

        return even;
    }


    public static ArrayList<Contact> selectListeContact(Context context, Long idEvenement) {

        ArrayList<Contact> liste = new ArrayList<Contact>();

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        Cursor curseur = base.rawQuery("SELECT * FROM Contact WHERE idEvenement =?"
                , new String[] {idEvenement.toString() });

        int nblignes = curseur.getCount();
        while (curseur.moveToNext()){
            Long idContact = curseur.getLong(0);
            //pas besoin de l'idEvenement, on l'a dans les parametre de la fonction
            String idTelephone = curseur.getString(2);

            Contact elem = new Contact(idContact,idEvenement,idTelephone);
            liste.add(elem);
        }

        base.close();
        helper.close();

        return liste;
    }


    public static ArrayList<SmsAuto> selectListeSmsAuto(Context context, Long idEvenement) {

        ArrayList<SmsAuto> liste = new ArrayList<SmsAuto>();

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        Cursor curseur = base.rawQuery("SELECT * FROM SmsAuto WHERE idEvenement =?"
                , new String[] {idEvenement.toString() });

        int nblignes = curseur.getCount();
        while (curseur.moveToNext()){
            Long idSms = curseur.getLong(0);
            //idEvenement
            String text = curseur.getString(2);
            int mYear = curseur.getInt(3);
            int mMonth = curseur.getInt(4);
            int mDay = curseur.getInt(5);
            int heure = curseur.getInt(6);
            int minutes = curseur.getInt(7);

            SmsAuto elem = new SmsAuto(idSms,idEvenement,text,mYear,mMonth,mDay,heure,minutes);
            liste.add(elem);
        }

        base.close();
        helper.close();

        return liste;
    }

    public static void terminerEvenementBdd(Context context, Long idEvenement){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        base.rawQuery("DELETE FROM Contact WHERE idEvenement =?"
                , new String[] {idEvenement.toString() });
        base.rawQuery("DELETE FROM SmsAuto WHERE idEvenement =?"
                , new String[]{idEvenement.toString()});
        base.rawQuery("DELETE FROM Evenement WHERE idEvenement =?"
                , new String[] {idEvenement.toString() });

        base.close();
        helper.close();
    }

    public static void renouvellerContacts(Context context, Long idEvenement){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        base.rawQuery("DELETE FROM Contact WHERE idEvenement =?"
                , new String[] {idEvenement.toString() });

        base.close();
        helper.close();
    }

}



//myDate=new Date(cursor.getLong(DATE_COL_INDEX));
