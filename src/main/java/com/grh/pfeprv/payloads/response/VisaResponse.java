package com.grh.pfeprv.payloads.response;

import com.grh.pfeprv.enums.ETypeVisa;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;

@Data
public class VisaResponse {
    private Long id;
    private Date datedepot;
    private String status;
    @Enumerated(EnumType.STRING)
    private ETypeVisa typevisa;
    private String nom;
    private String prenom;
    private String post;
    private String jobid;

    public VisaResponse(Long id, Date datedepot, String status, ETypeVisa typevisa,
                        String nom, String prenom, String post, String jobid) {
        this.id = id;
        this.datedepot = datedepot;
        this.status = status;
        this.typevisa = typevisa;
        this.nom = nom;
        this.prenom = prenom;
        this.post = post;
        this.jobid = jobid;
    }
}
