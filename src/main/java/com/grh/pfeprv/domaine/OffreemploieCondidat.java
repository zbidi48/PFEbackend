package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusOffreCondidat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OffreemploieCondidat")
public class OffreemploieCondidat {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "condidats_id")
    @JsonIgnore
    private  Condidats condidats;
    @ManyToOne
    @JoinColumn(name = "offreemploie_id")
    @JsonIgnore
    private Offreemploie offreemploie;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datecreation;
    @Enumerated(EnumType.STRING)
    private EStatusOffreCondidat status;
    private Boolean suppr;


}
