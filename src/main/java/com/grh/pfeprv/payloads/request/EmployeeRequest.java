package com.grh.pfeprv.payloads.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private  String nom;
    private  String prenom;
    private  String post;
    private String email;
    private String status;
    private String salary;
    private String cnss;
    private String departement;
    private String jobid;

}
