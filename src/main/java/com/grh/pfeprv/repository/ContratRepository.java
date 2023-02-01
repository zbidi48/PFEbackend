package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findAllByDeletedIsFalse();

    List<Contrat> findAllByEmployee_IdAndDeletedIsFalse(Long emplid);

    List<Contrat> findAllByEmployee_NomAndDeletedIsFalseOrEmployee_PrenomAndDeletedIsFalseOrEmployee_JobidAndDeletedIsFalse(String nom,String prenom,String jobid);
}
