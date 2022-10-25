package com.grh.pfeprv.payloads.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private  Long id;
    private  String nom;
    private String prenom;
    private  String post;
    private String jobid;

    public EmployeeResponse(Long id,String nom, String prenom, String post, String jobid) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.post = post;
        this.jobid = jobid;
    }
}
