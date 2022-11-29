package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "fichedepaie")
public class Fichedepaie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private String salairenet;
    private String salairebrut;
    private Boolean suppr;
    @ManyToOne
    @JoinColumn( name="employee_id" )
    @JsonIgnore
    private Employee employee;
}
