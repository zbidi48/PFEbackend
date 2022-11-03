package com.grh.pfeprv.domaine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contrat")
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String code;

    private  String libelle;

    private Date datedebut;

    private  Date datefin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private  Employee employee;
    @JsonIgnore
    private boolean deleted;



}
