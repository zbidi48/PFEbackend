package com.grh.pfeprv.service.impl;


import com.grh.pfeprv.domaine.Meeting;
import com.grh.pfeprv.enums.EStatusMetting;

import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.MeetingRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.MeetingRepository;
import com.grh.pfeprv.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements IMeetingService {
    @Autowired
    MeetingRepository meetingRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Meeting> Affichermeeting() {
        return meetingRepository.findAll();
    }

    @Override
    public ResponseEntity<MessageResponse> Ajoutermeeting(MeetingRequest request) {
        Meeting meeting = new Meeting();
        meeting.setDate(request.getDate());
        meeting.setHeure(request.getHeure());
        meeting.setLienmeet(request.getLienmeet());
        meeting.setStatus(EStatusMetting.OK);
        meeting.setTypemeeting(request.getTypemeeting());
        meetingRepository.save(meeting);
        return ResponseEntity.ok(new MessageResponse("meting ajouter  avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Miseajourmeeting(Long id, MeetingRequest request) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        if(!meeting.isPresent())
        {
            throw new NotFoundException("meeting ID: " + id + " not found");
        }
        Meeting meeting1 = meeting.get();
        meeting1.setHeure(request.getHeure());
        meeting1.setTypemeeting(request.getTypemeeting());
        meeting1.setLienmeet(request.getLienmeet());
        meetingRepository.save(meeting1);
        return ResponseEntity.ok(new MessageResponse("meting mise a jour  avec succeé"));
    }

    @Override
    public ResponseEntity<Meeting> Detaillmeeting(Long id) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        if(!meeting.isPresent())
        {
            throw new NotFoundException("meeting ID: " + id + " not found");
        }
        return new  ResponseEntity<Meeting>(meeting.get(),HttpStatus.OK);
    }


   /*
    @Override
    public ResponseEntity<List<Meeting>> chercherpardate(Date date) {
        return ResponseEntity.ok(new ArrayList<>(meetingRepository.findAllByDate(date)));
    }
    */

    @Override
    public ResponseEntity<MessageResponse> changestatus(Long id, String status) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        if(!meeting.isPresent())
        {
            throw new NotFoundException("meeting ID: " + id + " not found");
        }
        Meeting meeting1 = meeting.get();

        if(status.equals("suspendu"))
        {
            meeting1.setStatus(EStatusMetting.SUSPENDU);
        }
        else
        {
            meeting1.setStatus(EStatusMetting.ANULLE);
        }
        meetingRepository.save(meeting1);
        return ResponseEntity.ok(new MessageResponse("status change  avec succeé"));
    }
}
