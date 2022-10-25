package com.grh.pfeprv.payloads.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;
@Data
public class FichdepaieRequest {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private String salairenet;
    private String salairebrut;

    private long employee_id;

}
