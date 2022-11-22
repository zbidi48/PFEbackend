package com.grh.pfeprv.payloads.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class OffrecondidatResponse {
    private  Long id;
    private  Date datecreation;
    private String nom;
    private String prenom;
    private  String cin;
    private  String poste;

    private String titredoffre;
    private String description;

    private Date datelimite;
    private String langue;
    private String experience;
    private String exigenceemploie;

    private String status;



    public OffrecondidatResponse(Long id, Date datecreation, String nom,
                                 String prenom, String cin,String poste,String titredoffre,
                                 String description,Date datelimite,String langue,String experience,
                                 String exigenceemploie,String status) {
        this.id = id;
        this.datecreation = datecreation;
        this.nom = nom;
        this.prenom = prenom;
        this.cin=cin;
        this.poste = poste;
        this.titredoffre=titredoffre;
        this.description=description;
        this.datelimite=datelimite;
        this.langue=langue;
        this.experience=experience;
        this.exigenceemploie=exigenceemploie;
        this.status=status;

    }
}
