package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge,Long> {
   //List<Conge> findCongeByEmployee_NomAndEmployee_Prenom(String nom,String prenom);
   List<Conge> findByEmployee_Email(String mail);
   List<Conge> findByEmployee_JobidAndAndSupprIsFalse(String jobid);
   List<Conge> findBySupprIsFalse();
}
