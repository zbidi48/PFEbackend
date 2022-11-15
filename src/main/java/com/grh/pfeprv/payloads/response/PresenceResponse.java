package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class PresenceResponse {
    private Long id;
    private Date date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time tempentre;
    @JsonFormat(pattern="HH:mm:ss")
    private Time tempsortie;
    private String nom;
    private String prenom;
    private String jobid;

    public PresenceResponse(Long id,
                            Date date,
                            Time tempentre,
                            Time tempsortie,
                            String nom,
                            String prenom,
                            String jobid) {
        this.id = id;
        this.date = date;
        this.tempentre=tempentre;
        this.tempsortie=tempsortie;
        this.nom = nom;
        this.prenom = prenom;
        this.jobid=jobid;
    }
}
