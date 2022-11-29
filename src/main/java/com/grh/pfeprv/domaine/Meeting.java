package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusMetting;
import com.grh.pfeprv.enums.EtypeMeeting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meeting")
public class Meeting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time heure;
    private String lienmeet;
    @Enumerated(EnumType.STRING)
    private EtypeMeeting typemeeting;
    @Enumerated(EnumType.STRING)
    private EStatusMetting status;

   /*
    @ManyToOne
    @JsonIgnore
    private Employee employee;
    */

}
