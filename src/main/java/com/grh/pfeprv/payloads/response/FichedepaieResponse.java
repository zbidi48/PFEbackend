package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.Date;
@Data
public class FichedepaieResponse {
    private  long id;
    private Date date;
    private String salairebrut;
    private String salairenet;
    private String nom;
    private String prenom;
    private String post;
    private String jobid;


    public FichedepaieResponse(long id, Date date, String salairebrut, String salairenet, String nom,
                               String prenom ,String post,String jobid) {
        this.id = id;
        this.date = date;
        this.salairebrut = salairebrut;
        this.salairenet = salairenet;
        this.nom = nom;
        this.prenom=prenom;
        this.post = post;
        this.jobid=jobid;

    }
}
