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
    Date date;
    Time heure;

    public Evenement(Long idEvenement, String nom, String description, Date date, Time heure) {
        this.idEvenement = idEvenement;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.heure = heure;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
}
