package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Offreemploie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffeemploieRepository extends JpaRepository<Offreemploie,Long> {
    //List<Offreemploie> findOffreemploieByTypedoffre(String typeoffre);
    //List<Offreemploie> findAllByTypedoffre(String typeoffre);
    List<Offreemploie> findByTitredoffre(String titredoffre);
}
