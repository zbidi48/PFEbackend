package com.grh.pfeprv.payloads.request;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Formation;
import com.grh.pfeprv.enums.EStatusInscritFormation;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
public class InscritFormationRequest {
    private Date dateinscrit;

    private Long employee_id;

    private Long formation_id;
    @Enumerated(EnumType.STRING)
    private EStatusInscritFormation status;
    private Boolean suppr;
}
