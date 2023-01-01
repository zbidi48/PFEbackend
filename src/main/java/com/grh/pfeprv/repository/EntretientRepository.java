package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Entretient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntretientRepository extends JpaRepository<Entretient,Long> {
   List<Entretient> findAllBySupprIsFalse();
   List<Entretient> findAllByCondidat_Email(String email);
   List<Entretient> findByCondidat_NomAndCondidat_PrenomAndSupprIsFalse(String nom,String prenom);
   List<Entretient> findAllByCondidat_CinAndSupprIsFalse(String cin);
   List<Entretient> findAllByCondidat_NomOrCondidat_PrenomOrCondidat_CinAndSupprIsFalse(String nom,String prenom,String cin);
}
