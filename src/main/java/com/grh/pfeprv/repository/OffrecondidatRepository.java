package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.OffreemploieCondidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffrecondidatRepository extends JpaRepository<OffreemploieCondidat,Long> {

    List<OffreemploieCondidat> findByCondidats_Email(String mail);
    List<OffreemploieCondidat> findByStatus(String status);
    List<OffreemploieCondidat> findByOffreemploie_Titredoffre(String titredoffre );
    List<OffreemploieCondidat> findBySupprIsFalse();


}
