package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grh.pfeprv.enums.EStatusConge;
import com.grh.pfeprv.enums.ETypeConge;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
public class CongeResponse {
    private  long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datefin;
   /*
    @Enumerated(EnumType.STRING)
    private EStatusConge statusConge;

    */
    private String statusConge;
    @Enumerated(EnumType.STRING)
    private ETypeConge typeConge;

    private  String nom;
    private String prenom;
    private String post;
    private String jobid;

    public CongeResponse(Long id, Date datedebut, Date datefin,
                        String statusConge, ETypeConge typeConge,
                         String nom, String prenom, String post, String jobid) {
        this.id = id;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.statusConge = statusConge;
        this.typeConge = typeConge;
        this.nom = nom;
        this.prenom = prenom;
        this.post = post;
        this.jobid = jobid;
    }
}
