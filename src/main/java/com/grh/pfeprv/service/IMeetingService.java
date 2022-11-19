package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Meeting;
import com.grh.pfeprv.payloads.request.MeetingRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface IMeetingService {
    public List<Meeting> Affichermeeting();
    public  ResponseEntity<MessageResponse> Ajoutermeeting(MeetingRequest request );
   public ResponseEntity<MessageResponse> Miseajourmeeting(Long id, MeetingRequest request);
   public  ResponseEntity<Meeting> Detaillmeeting(Long id);

    //public  ResponseEntity<List<Meeting>> chercherpardate(Date date);
    public ResponseEntity<MessageResponse> changestatus(Long id,String status);

}
