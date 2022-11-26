package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.EvaluationFormation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationFormationRepository extends JpaRepository<EvaluationFormation,Long> {
    Long countAllByAvis(String avis);


}
