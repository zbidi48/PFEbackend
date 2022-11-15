package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data

public class PresenceRequest {
    /*
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
     */


    @JsonFormat(pattern="HH:mm:ss")
    private Time tempentre;
    @JsonFormat(pattern="HH:mm:ss")
    private Time tempsortie;

    private long employee_id;
    private Boolean suppr;
}
