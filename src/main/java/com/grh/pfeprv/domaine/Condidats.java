package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name ="condidats" ,uniqueConstraints = {@UniqueConstraint(columnNames = "cin")} )
@DiscriminatorValue("condidat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condidats extends User{
    private static final long serialVersionUID = 1L;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfBirth;
    private String phone;
    private String adresse ;
    private String ville;
    private String nationality;
    private String niveauEtud;
    private String titreDiplome;
    private String university;
    private String niveauExp;

    private String cin;
    private String competences;
    private Boolean suppr;
    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entretient_id", referencedColumnName = "id")
    private Entretient entretient;
     */

}
