package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Notedefraie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotedefraieRepository extends JpaRepository<Notedefraie,Long> {
    List<Notedefraie> findAllBySupprimerIsFalse();
    List<Notedefraie> findByEmployee_NomAndAndEmployee_Prenom(String nom,String prenom);
    List<Notedefraie> findByEmployee_Email(String mail);
    List<Notedefraie> findByEmployee_Jobid(String jobid);
}
