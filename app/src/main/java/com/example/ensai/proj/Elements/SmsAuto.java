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
    Date date;
    Time time;

    public SmsAuto(Long idSms, Long idEvenement, String texte, Date date, Time time) {
        this.idSms = idSms;
        this.idEvenement = idEvenement;
        this.texte = texte;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
