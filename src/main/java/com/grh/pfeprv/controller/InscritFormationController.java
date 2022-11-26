package com.grh.pfeprv.controller;

import com.grh.pfeprv.payloads.response.InscritFormationResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;

import com.grh.pfeprv.service.InscritFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscritformation")
@CrossOrigin("*")
public class InscritFormationController {
    @Autowired
    InscritFormationService service;
    @GetMapping("/afficherinscritformation")
    public ResponseEntity<List<InscritFormationResponse>> afficherinscritformation()
    {
        return new ResponseEntity(service.Afficherinscritformation(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/deatilleinscrit/{id}")
    public ResponseEntity<InscritFormationResponse> detaillinscrit(@PathVariable(value="id") Long id)
    {
        return service.Detailleinscritformation(id);
    }
    @PostMapping("/inscritformation/{idemployee}/{idformation}")
    public  ResponseEntity<MessageResponse> inscritformation(@PathVariable(value="idemployee") Long idemployee,
                                                             @PathVariable(value ="idformation") Long idformation)
    {
        return service.Inscritformation(idemployee,idformation);
    }
    @DeleteMapping("/supprimerinscritformation/{id}")
    public ResponseEntity<MessageResponse> suprimerinscritformation(@PathVariable(value="id") Long id)
    {
        return service.Supprimerinscrit(id);
    }
    @GetMapping("/chercherinscritformation/{jobid}")
    public ResponseEntity<List<InscritFormationResponse> > chercherinscritformation(@PathVariable(value="jobid") String jobid)
    {
        return ResponseEntity.ok(service.Chercherinscritformationparjobid(jobid));
    }
    @GetMapping("/afficherinscritparemplyeeid/{employeeid}")
    public ResponseEntity<List<InscritFormationResponse>> afficherinscritformationparemployeeid(@PathVariable(value="employeeid")
                                                                                    Long employeeid)
    {
        return ResponseEntity.ok(service.Afficherinscritformationparemployeeid(employeeid));
    }
    @PutMapping("/changerstatusinscritformation/{id}/{status}")
    public ResponseEntity<MessageResponse> changerstatus(@PathVariable(value="id") Long id,
                                                         @PathVariable(value ="status") String status)
    {
        return service.changersatus(id,status);
    }

}
