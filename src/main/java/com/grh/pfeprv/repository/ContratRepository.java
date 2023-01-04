package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findAllByDeletedIsFalse();
    List<Contrat> findAllByEmployee_JobidAndDeletedIsFalse(String jobid);
    List<Contrat> findAllByCodeAndDeletedIsFalse(String code);
    List<Contrat> findAllByEmployee_IdAndDeletedIsFalse(Long emplid);
    List<Contrat> findAllByEmployee_NomAndEmployee_PrenomAndAndDeletedIsFalse(String nom ,String prenom);
    List<Contrat> findAllByEmployee_NomAndDeletedIsFalseOrEmployee_PrenomAndDeletedIsFalseOrEmployee_JobidAndDeletedIsFalseOrCodeAndDeletedIsFalse(String nom,String prenom,String jobid,String code);
}
