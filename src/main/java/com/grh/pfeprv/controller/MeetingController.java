package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Meeting;
import com.grh.pfeprv.payloads.request.MeetingRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/meeting")
@CrossOrigin("*")
public class MeetingController {
    @Autowired
    private  IMeetingService service;
    @GetMapping("/listmeeting")
    public ResponseEntity<List<Meeting>> Affichermeet()
    {

        return ResponseEntity.ok(service.Affichermeeting());
    }
    @PostMapping("/ajoutmeet")
    public ResponseEntity<MessageResponse> AjoutMeet(@RequestBody MeetingRequest request)
    {
        return service.Ajoutermeeting(request);
    }
    @GetMapping("/detaillemeeting/{id}")
    public ResponseEntity<Meeting> Detailmeet(@PathVariable(name ="id") Long id)
    {
        return service.Detaillmeeting(id);
    }
    @PutMapping("/miseajourmeeting/{id}")
    public ResponseEntity<MessageResponse> Miseajourmeet(@PathVariable(name ="id") Long id
            ,@RequestBody MeetingRequest request)
    {
        return service.Miseajourmeeting(id,request);
    }
   /*
    @GetMapping("/cherchermeeting/{date}")
    public ResponseEntity<List<Meeting>> Cherchermeetingpardate(Date date)
    {
        return service.chercherpardate(date);
    }
    */
    @PutMapping("/changestatusmeet/{id}/{status}")
    public ResponseEntity<MessageResponse> Changestatus(@PathVariable(name ="id") Long id
            ,@PathVariable(name ="status") String status)
    {
        return service.changestatus(id,status);
    }
}
