package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "presence")
public class Presence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time tempentre;
    @JsonFormat(pattern="HH:mm:ss")
    private Time tempsortie;
    private Boolean suppr;
    @ManyToOne
    @JoinColumn( name="employee_id" )
    @JsonIgnore
    private Employee employee;

    /*
    { id: 1,
        date : 9/4/2022,
        nbreheure: 8,
        user: {Ahmed}
        },
        { id: 2,
        date : 9/4/2022,
        nbreheure: 8,
        user: {Ahmed}
        }
     */


}
