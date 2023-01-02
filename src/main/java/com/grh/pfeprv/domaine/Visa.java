package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusVisa;
import com.grh.pfeprv.enums.ETypeVisa;
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
@Table(name = "visa")
public class Visa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedepot;
    @Enumerated(EnumType.STRING)
    private EStatusVisa status;
    @Enumerated(EnumType.STRING)
    private ETypeVisa typevisa;
    private Boolean suppr;
    @ManyToOne
    @JoinColumn( name="employee_id" )
    @JsonIgnore
    private  Employee employee;
}
