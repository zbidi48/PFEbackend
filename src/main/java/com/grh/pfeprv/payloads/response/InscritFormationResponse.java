package com.grh.pfeprv.payloads.response;

import com.grh.pfeprv.enums.EStatusInscritFormation;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class InscritFormationResponse {
    private Long id;
    @Enumerated(EnumType.STRING)
    private EStatusInscritFormation status;
    private String nom;
    private String prenom;
    private String jobid;
    private  String nomdeforamtion;
    private  String typedeformation;

    public InscritFormationResponse(Long id, EStatusInscritFormation status, String nom, String prenom,
                                    String jobid, String nomdeforamtion, String typedeformation) {
        this.id = id;
        this.status = status;
        this.nom = nom;
        this.prenom = prenom;
        this.jobid = jobid;
        this.nomdeforamtion = nomdeforamtion;
        this.typedeformation = typedeformation;
    }
}
