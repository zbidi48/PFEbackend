package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grh.pfeprv.enums.EStatusEntretient;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
public class EntretientRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private String heure;
    @Enumerated(EnumType.STRING)
    private EStatusEntretient status;
    private Long condidats_id;
    private boolean suppr;
}