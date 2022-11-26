package com.grh.pfeprv.payloads.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class OffreemploieRequest {


    private  String titredoffre;

    private Date datelimite;
    private String description;
    private String langue;
    private String experience;
    private String exigenceemploie;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private String datecreation;

}
