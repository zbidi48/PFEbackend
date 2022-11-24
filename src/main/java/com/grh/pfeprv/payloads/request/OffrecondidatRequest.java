package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.enums.EStatusOffreCondidat;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data

public class OffrecondidatRequest {



    private  Long condidats_id;
    private Long offreemploie_id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datecreation;
    @Enumerated(EnumType.STRING)
    private EStatusOffreCondidat status;
    private Boolean suppr;


}
