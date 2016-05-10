package com.example.ensai.proj.Elements;




import java.sql.Time;
import java.util.Date;

/**
 * Created by ensai on 10/05/16.
 */
public class SmsAuto {

    Long idSms;
    Long idEvenement;
    String texte;
    int mYear;
    int mMonth;
    int mDay;
    int heure;
    int minutes;

    public SmsAuto(Long idSms, Long idEvenement, String texte, int mYear, int mMonth, int mDay, int heure, int minutes) {
        this.idSms = idSms;
        this.idEvenement = idEvenement;
        this.texte = texte;
        this.mYear = mYear;
        this.mMonth = mMonth;
        this.mDay = mDay;
        this.heure = heure;
        this.minutes = minutes;
    }

    public SmsAuto() {
    }

    public Long getIdSms() {
        return idSms;
    }

    public void setIdSms(Long idSms) {
        this.idSms = idSms;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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
