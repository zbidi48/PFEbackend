package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.Date;
@Data
public class EntretientResponse {
    private Long id;
    private Date date;
    private String heure;
    private String status;
    private String nom;
    private String prenom;

    public EntretientResponse(Long id, Date date, String heure, String status,String nom, String prenom) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.status=status;
        this.nom = nom;
        this.prenom = prenom;
    }
}
