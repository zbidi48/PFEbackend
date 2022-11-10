package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusConge;
import com.grh.pfeprv.enums.ETypeConge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conge")
public class Conge  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datefin;
    private Boolean suppr;

    /*
    @Enumerated(EnumType.STRING)
    private EStatusConge statusConge;
     */

    @Enumerated(EnumType.STRING)
    private ETypeConge typeConge;

    private String statusConge;
    @ManyToOne
    @JoinColumn( name="employee_id" )
    @JsonIgnore
    private  Employee employee;
}
