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

}
