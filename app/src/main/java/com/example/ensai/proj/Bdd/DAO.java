package com.example.ensai.proj.Bdd;

import android.content.Context;
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


    /**
     * Méthode pour insérer un Evenement en bdd
     *
     * @param context
     * @param nom
     * @param description
     * @param date
     * @param heure
     */
    public static void insertEvenement(Context context, String nom, String description, Date date, Time heure){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO Evenement " +
                "(nom, description, date, heure) VALUES(?,?,?,?)");
        rqt.bindString(1,nom);
        rqt.bindString(2, description);
        rqt.bindLong(3, Long.parseLong(date.toString()));
        rqt.bindLong(4, Long.parseLong(heure.toString()));

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

    public static void insertContact(Context context, long idEvenement, long  idTelephone){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO Contact " +
                "(idEvenement, idTelephone) VALUES(?,?)");
        rqt.bindLong(1, idEvenement);
        rqt.bindLong(2, idTelephone);

        rqt.execute();
        base.close();
        helper.close();

    }

    /**
     * Méthode pour insérer un sms en bdd
     *
     * @param context
     * @param idEvenement
     * @param texte
     * @param date
     * @param heure
     */

    public static void insertSmsAuto(Context context, Long idEvenement, String texte, Date date, Time heure){

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getWritableDatabase();

        SQLiteStatement rqt = base.compileStatement("INSERT INTO SmsAuto " +
                "(idEvenement, texte, date, heure) VALUES(?,?,?,?)");
        rqt.bindLong(1,idEvenement);
        rqt.bindString(2, texte);
        rqt.bindLong(3, Long.parseLong(date.toString()));
        rqt.bindLong(4, Long.parseLong(heure.toString()));

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
    public static ArrayList<Evenement> selectEvenement(Context context) {

        SQLiteOpenHelper helper = new OpenHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();

        SQLiteStatement rqt = base.compileStatement("SELECT * FROM Evenement");

        rqt.execute();




        base.close();
        helper.close();

        return null;
    }


    public static ArrayList<Contact> selectContact(Context context, Long idEvenement) {
        return null;
    }


    public static ArrayList<SmsAuto> selectSmsAuto(Context context, Long idEvenement) {
        return null;
    }

}



//myDate=new Date(cursor.getLong(DATE_COL_INDEX));
