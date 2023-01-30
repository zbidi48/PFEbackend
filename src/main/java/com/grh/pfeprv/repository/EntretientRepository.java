package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Entretient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntretientRepository extends JpaRepository<Entretient,Long> {
    List<Entretient> findAllByCondidat_Email(String email);
 /*  List<Entretient> findAllBySupprIsFalse();*/
/*

*/

/*
   List<Entretient> findAllByCondidat_NomAndSupprIsFalseOrCondidat_PrenomAndSupprIsFalseOrCondidat_CinAndSupprIsFalse(String nom,String prenom,String cin);
*/
}
