package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {




   List<Employee> findBySupprIsFalse();
   List<Employee> findAllByNomAndSupprIsFalseOrPrenomAndSupprIsFalseOrJobidAndSupprIsFalse(String nom,String prenom,String jobid );








}
