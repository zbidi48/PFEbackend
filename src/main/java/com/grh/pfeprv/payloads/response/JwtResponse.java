package com.grh.pfeprv.payloads.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private Long id;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, Long id, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }
}
