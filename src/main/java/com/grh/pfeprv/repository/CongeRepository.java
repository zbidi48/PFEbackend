package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge,Long> {

   List<Conge> findByEmployee_Email(String mail);

   List<Conge> findBySupprIsFalse();
   List<Conge> findAllByEmployee_NomAndSupprIsFalseOrEmployee_PrenomAndSupprIsFalseOrEmployee_JobidAndSupprIsFalse(String nom,String prenom,String jobid);
}
