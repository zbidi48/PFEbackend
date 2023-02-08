package com.grh.pfeprv.domaine;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor

public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;



    private  String type;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private  Employee employee;
    @JsonIgnore
    private boolean deleted;

    private String url;



}
