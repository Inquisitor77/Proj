package com.example.ensai.proj.Elements;

/**
 * Created by ensai on 12/05/16.
 */
public class ContactTel {

    String idTel;
    String nom;
    String numero;
    Boolean selected;

    public ContactTel(String idTel, String nom, String numero) {
        this.idTel = idTel;
        this.nom = nom;
        this.numero = numero;
    }

    public ContactTel(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString(){
        return nom;
    }

    public String getIdTel() {
        return idTel;
    }

    public void setIdTel(String idTel) {
        this.idTel = idTel;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
