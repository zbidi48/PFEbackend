package com.grh.pfeprv.payloads.request;

import lombok.Data;

import java.util.Date;
@Data
public class EntretientRequest {
    private Date date;
    private String heure;
    private Long condidats_id;
}
