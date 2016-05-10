package com.example.ensai.proj.Bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.PreparedStatement;

/**
 * Created by ensai on 10/05/16.
 */
public class OpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BaseDeDonnee";

    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Evenement (idEvenement INTEGER PRIMARY KEY, nom TEXT, description TEXT, date INTEGER, heure INTEGER)");
        db.execSQL("CREATE TABLE Contact (idContact INTEGER PRIMARY KEY, idEvenement INTEGER FOREIGN KEY REFERENCES Evenement, idTelephone INTEGER)");
        db.execSQL("CREATE TABLE SmsAuto (idSms INTEGER PRIMARY KEY, idEvenement INTEGER FOREIGN KEY REFERENCES Evenement, texte TEXT, date INTEGER, heure INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
