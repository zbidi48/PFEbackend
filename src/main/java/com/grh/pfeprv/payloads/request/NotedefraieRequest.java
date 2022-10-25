package com.grh.pfeprv.payloads.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class NotedefraieRequest {
    private  String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datecreation;

    private String fraie;
    private Boolean supprimer;
    private Long employee_id;
}
