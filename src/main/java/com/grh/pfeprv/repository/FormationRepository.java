package com.grh.pfeprv.repository;


import com.grh.pfeprv.domaine.Formation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByTypedeformationOrNomdeforamtion(String nomform,String typeFor);
    @Query(value = "SELECT count(id) FROM public.formation ", nativeQuery = true)
    long nbrformation();

}
