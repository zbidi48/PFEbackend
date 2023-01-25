package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grh.pfeprv.enums.EStatusEntretient;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.sql.Time;
import java.sql.Date;


@Data
public class EntretientRequest {
   /* @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")*/
    private Date date;
    /*@JsonFormat(pattern="HH:mm:ss")*/
    private Time heure;

    private Long inscritoffre_id;
   /* private boolean suppr;*/
}