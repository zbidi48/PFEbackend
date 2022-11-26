package com.grh.pfeprv.domaine;

import com.grh.pfeprv.enums.Eevaluationformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluationformation")
public class EvaluationFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String avis;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formation_id", referencedColumnName = "id")
    private Formation formation;




}
