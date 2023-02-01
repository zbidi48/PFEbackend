package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.InscritFormation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscritFormationRepository extends JpaRepository<InscritFormation,Long> {
    List<InscritFormation> findAllBySupprIsFalse();


    List<InscritFormation> findByEmployee_Email(String mail);
    List<InscritFormation> findByEmployee_IdAndSupprIsFalse(Long id);
    List<InscritFormation> findAllByEmployee_NomAndSupprIsFalseOrEmployee_PrenomAndSupprIsFalseOrEmployee_JobidAndSupprIsFalseOrFormation_NomdeforamtionOrFormation_Typedeformation(String nom,String prenom,String jobid,String nomformation,String typeformation);

}
