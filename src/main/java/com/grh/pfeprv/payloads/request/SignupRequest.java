package com.grh.pfeprv.payloads.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;

}
