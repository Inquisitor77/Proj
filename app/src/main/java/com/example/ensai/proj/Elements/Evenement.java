package com.example.ensai.proj.Elements;

import java.sql.Time;
import java.util.Date;

/**
 * Created by ensai on 10/05/16.
 */
public class Evenement {

    Long idEvenement;
    String nom;
    String description;
    int mYear;
    int mMonth;
    int mDay;
    int heure;
    int minutes;

    public Evenement(Long idEvenement, String nom, String description, int mYear, int mMonth, int mDay, int heure, int minutes) {
        this.idEvenement = idEvenement;
        this.nom = nom;
        this.description = description;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.heure = heure;
        this.minutes = minutes;
    }

    public Evenement() {
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public int getmMonth() {
        return mMonth;
    }

    public void setmMonth(int mMonth) {
        this.mMonth = mMonth;
    }

    public int getmDay() {
        return mDay;
    }

    public void setmDay(int mDay) {
        this.mDay = mDay;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
