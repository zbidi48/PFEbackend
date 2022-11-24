package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Condidats;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CondidatRepository extends JpaRepository<Condidats,Long> {
   List<Condidats> findBySupprIsFalse();
   List<Condidats> findAllByNomAndPrenomAndSupprIsFalse(String nom,String prenom);
   List<Condidats> findAllByCinAndSupprIsFalse(String cin);
}
