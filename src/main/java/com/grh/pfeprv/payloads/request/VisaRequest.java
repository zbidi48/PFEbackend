package com.grh.pfeprv.payloads.request;


import com.grh.pfeprv.enums.ETypeVisa;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;


@Data

public class VisaRequest {
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedepot;
    private String status;
    @Enumerated(EnumType.STRING)
    private ETypeVisa typevisa;
    private Boolean suppr;
    private Long employee_id;
}
