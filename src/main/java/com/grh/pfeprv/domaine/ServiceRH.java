package com.grh.pfeprv.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name ="serviceRH" ,uniqueConstraints = {@UniqueConstraint(columnNames = "jobid")})
@DiscriminatorValue("RH")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRH extends User {
    private static final long serialVersionUID = 1L;
    private String departement;
    private String jobid;


}
