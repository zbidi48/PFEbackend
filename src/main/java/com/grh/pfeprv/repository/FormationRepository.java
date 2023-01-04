package com.grh.pfeprv.repository;


import com.grh.pfeprv.domaine.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByTypedeformationOrNomdeforamtion(String nomform,String typeFor);

}
