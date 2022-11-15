package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusInscritFormation;
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
@Table(name = "inscritformation")
public class InscritFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateinscrit;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private  Employee employee;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
    @Enumerated(EnumType.STRING)
    private EStatusInscritFormation status;

}
