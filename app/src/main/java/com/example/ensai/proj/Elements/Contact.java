package com.example.ensai.proj.Elements;

/**
 * Created by ensai on 10/05/16.
 */
public class Contact {

    Long idContact;
    Long idEvenement;
    String idTelephone;

    public Contact(Long idContact, Long idEvenement, String idTelephone) {
        this.idContact = idContact;
        this.idEvenement = idEvenement;
        this.idTelephone = idTelephone;
    }

    public Contact() {
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getIdTelephone() {
        return idTelephone;
    }

    public void setIdTelephone(String idTelephone) {
        this.idTelephone = idTelephone;
    }
}
