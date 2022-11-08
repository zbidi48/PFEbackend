package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.Date;

@Data
public class PresenceResponse {
    private Long id;
    private Date date;
    private  double nbreheure;
    private String nom;
    private String prenom;
    private String jobid;

    public PresenceResponse(Long id,
                            Date date,
                            double nbreheure,
                            String nom,
                            String prenom,
                            String jobid) {
        this.id = id;
        this.date = date;
        this.nbreheure = nbreheure;
        this.nom = nom;
        this.prenom = prenom;
        this.jobid=jobid;
    }
}
