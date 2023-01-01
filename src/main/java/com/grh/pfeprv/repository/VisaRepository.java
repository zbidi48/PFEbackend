package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaRepository extends JpaRepository<Visa,Long> {
   List<Visa> findAllBySupprIsFalse();
   List<Visa> findByEmployee_Email(String email);
   List<Visa> findAllByEmployee_NomAndEmployee_PrenomAndSupprIsFalse(String nom,String prenom);
   List<Visa> findByEmployee_JobidAndAndSupprIsFalse(String jobid);
   List<Visa> findAllByEmployee_NomAndSupprIsFalseOrEmployee_PrenomAndSupprIsFalseOrEmployee_JobidAndSupprIsFalse(String nom,String prenom,String jobid);
}
