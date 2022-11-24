package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grh.pfeprv.enums.EStatusInscritFormation;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.util.Date;

@Data
public class InscritFormationResponse {
    private Long id;
    @Enumerated(EnumType.STRING)
    private EStatusInscritFormation status;
    private String nom;
    private String prenom;
    private String jobid;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateinscrit;
    private  String nomdeforamtion;
    private  String typedeformation;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;
    private Time heure;

    public InscritFormationResponse() {

    }

    public InscritFormationResponse(Long id, EStatusInscritFormation status, String nom, String prenom,
                                    String jobid, Date dateinscrit,String nomdeforamtion, String typedeformation,Date datedebut,
                                    Time heure) {
        this.id = id;
        this.status = status;
        this.nom = nom;
        this.prenom = prenom;
        this.jobid = jobid;
        this.dateinscrit=dateinscrit;
        this.nomdeforamtion = nomdeforamtion;
        this.typedeformation = typedeformation;
        this.datedebut=datedebut;
        this.heure=heure;
    }
}
