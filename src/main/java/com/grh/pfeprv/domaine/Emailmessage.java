package com.grh.pfeprv.domaine;

import lombok.Data;

@Data
public class Emailmessage {
    private String to_address;
    private String subject;
    private String body;
}
