package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Fichedepaie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FichedepaieRepository extends JpaRepository<Fichedepaie,Long> {

   //List<Fichedepaie> findAllByUser_Id(Long id);
   //List<Fichedepaie> findAllByUser_NomAndUser_Prenom(String nom,String prenom);
   List<Fichedepaie> findByEmployee_Id(Long id);
   List<Fichedepaie> findByEmployee_NomAndAndEmployee_Prenom(String nom,String prenom);
}
