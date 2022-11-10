package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    //List<Employee> findEmployeeByNomAndPrenom(String nom,String prenom);
    //List<Employee> findByNomAndPrenom(String nom,String prenom);
    Employee findByJobidAndAndSupprIsFalse(String jobid);
   List<Employee> findBySupprIsFalse();








}
