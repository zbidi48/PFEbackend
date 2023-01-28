package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
public class OffrecondidatResponse {
    private  Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private  Date datecreation;
    private String nom;
    private String prenom;
    private  String cin;
    private  String poste;
    private Date dateOfBirth;
    private String phone;
    private String adresse ;
    private String ville;
    private String nationality;
    private String niveauEtud;
    private String titreDiplome;
    private String university;
    private String niveauExp;
    private String experience;

    private String titredoffre;
    private String description;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")

    private Date datelimite;
    private String langue;

    private String exigenceemploie;

    private String status;
    private Boolean hasinterview;



    public OffrecondidatResponse(Long id, Date datecreation, String nom,
                                 String prenom, String cin,String poste,Date dateOfBirth,
                                 String phone,
                                 String adresse,
                                 String ville,
                                 String nationality,
                                 String niveauEtud,
                                 String titreDiplome,
                                 String university,
                                 String niveauExp,
                                 String titredoffre,
                                 String description,Date datelimite,String langue,String experience,
                                 String exigenceemploie,String status, Boolean hasinterview) {
        this.id = id;
        this.datecreation = datecreation;
        this.nom = nom;
        this.prenom = prenom;
        this.cin=cin;
        this.poste = poste;
        this.dateOfBirth=dateOfBirth;
        this.phone=phone;
        this.adresse=adresse;
        this.ville=ville;
        this.nationality=nationality;
        this.niveauEtud=niveauEtud;
        this.titreDiplome=titreDiplome;
        this.university=university;
        this.niveauExp=niveauExp;
        this.titredoffre=titredoffre;
        this.description=description;
        this.datelimite=datelimite;
        this.langue=langue;
        this.experience=experience;
        this.exigenceemploie=exigenceemploie;
        this.status=status;
        this.hasinterview = hasinterview;

    }
}
