package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grh.pfeprv.enums.EStatusConge;
import com.grh.pfeprv.enums.ETypeConge;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class CongeRequest {
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datefin;
    /*
    @Enumerated(EnumType.STRING)
    private EStatusConge statusConge;
     */
    private String statusConge;
    @Enumerated(EnumType.STRING)
    private ETypeConge typeConge;
    private Boolean suppr;
    private Long employee_id;
}
