package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {



    List<Employee> findAllByNomAndPrenom(String nom,String prenom);
   List<Employee> findByJobidAndAndSupprIsFalse(String jobid);
   List<Employee> findBySupprIsFalse();
   List<Employee> findAllByNomOrPrenomAndSupprIsFalse(String nom,String prenom);








}
