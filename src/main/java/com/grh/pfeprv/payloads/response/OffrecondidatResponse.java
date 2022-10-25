package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.Date;
@Data
public class OffrecondidatResponse {
    private  Long id;
    private  Date datecreation;
    private String nomcondidat;
    private String prenomcondidat;
    private  String poste;

    public OffrecondidatResponse(Long id, Date datecreation, String nomcondidat, String prenomcondidat, String poste) {
        this.id = id;
        this.datecreation = datecreation;
        this.nomcondidat = nomcondidat;
        this.prenomcondidat = prenomcondidat;
        this.poste = poste;
    }
}
