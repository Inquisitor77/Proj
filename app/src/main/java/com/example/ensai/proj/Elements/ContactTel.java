package com.example.ensai.proj.Elements;

/**
 * Created by ensai on 12/05/16.
 */
public class ContactTel {

    String nom;
    String numero;

    public ContactTel(String nom, String numero) {
        this.nom = nom;
        this.numero = numero;
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
}
