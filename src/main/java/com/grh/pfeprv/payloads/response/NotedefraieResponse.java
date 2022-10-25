package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.Date;
@Data
public class NotedefraieResponse {
    private Long id;
    private  String description;
    private Date datecreation;

    private String fraie;
    private String nom;
    private String prenom;
    private String jobid;

    public NotedefraieResponse(Long id, String description, Date datecreation,
                               String fraie, String nom, String prenom, String jobid)
    {
        this.id = id;
        this.description = description;
        this.datecreation = datecreation;

        this.fraie = fraie;
        this.nom = nom;
        this.prenom = prenom;
        this.jobid = jobid;
    }
}
