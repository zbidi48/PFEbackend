package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class EntretientResponse {
    private Long id;
    private Date date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time heure;
    private String status;
    private String nom;
    private String prenom;
    private String cin;

    public EntretientResponse(Long id, Date date, Time heure, String status,String nom, String prenom,String cin) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.status=status;
        this.nom = nom;
        this.prenom = prenom;
        this.cin=cin;
    }
}
