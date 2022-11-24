package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grh.pfeprv.enums.EStatusEntretient;
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
@Table(name = "entretient")
public class Entretient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    @JsonFormat(pattern="HH:mm:ss")
    private Time heure;
    @Enumerated(EnumType.STRING)
    private EStatusEntretient status;
    @JsonIgnore
    private boolean suppr;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "condidats_id", referencedColumnName = "id")
    @JsonIgnore
    private Condidats condidat;

}
