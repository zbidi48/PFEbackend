package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaRepository extends JpaRepository<Visa,Long> {
   List<Visa> findAllBySupprIsFalse();
   List<Visa> findByEmployee_Email(String email);
   //List<Visa> findVisaByEmployee_NomAndEmployee_Prenom(String nom,String prenom);
   List<Visa> findByEmployee_JobidAndAndSupprIsFalse(String jobid);
}
