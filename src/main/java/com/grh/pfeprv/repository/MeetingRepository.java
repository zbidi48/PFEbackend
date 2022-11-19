package com.grh.pfeprv.repository;

import com.grh.pfeprv.domaine.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    List<Meeting> findAllByDate(Date date);
}
