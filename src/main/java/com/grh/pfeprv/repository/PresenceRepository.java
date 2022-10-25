package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence,Long> {

    List<Presence> findAllByUser_Id(Long id);
    List<Presence> findAllByUser_Email(String email);

}
