package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.OffreemploieCondidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffrecondidatRepository extends JpaRepository<OffreemploieCondidat,Long> {

    List<OffreemploieCondidat> findByCondidats_Email(String mail);
    //List<OffreemploieCondidat> findByStatus(String status);
    List<OffreemploieCondidat> findAllByCondidats_Cin(String cin);


    List<OffreemploieCondidat> findAllByCondidats_NomOrCondidats_PrenomOrCondidats_Cin(String nom,String prenom,String jobid);


}
