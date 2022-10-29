package com.grh.pfeprv.payloads.request;

import com.grh.pfeprv.enums.ETypeVisa;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data

public class VisaRequest {

    private Date datedepot;
    private String status;
    @Enumerated(EnumType.STRING)
    private ETypeVisa typevisa;
    private Boolean suppr;
    private Long employee_id;
}
