package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.payloads.request.OffrecondidatRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.OffrecondidatResponse;
import com.grh.pfeprv.service.IOffeCondidatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscritoffre")
@CrossOrigin("*")
public class OffrecondidatController {
    @Autowired
    IOffeCondidatService service;

    @GetMapping("/afficherinscripoffre")
    public ResponseEntity<List<OffrecondidatResponse>> Afficherinscriptionoffre()
    {

        return ResponseEntity.ok(service.Afficherinscriptionoffre());
    }
    @GetMapping("/inscritoffredetail/{id}")
    public ResponseEntity<OffrecondidatResponse> detaillinscritoffre(@PathVariable(value="id") Long id)
    {
        return new ResponseEntity(service.Afficherinscripparid(id), HttpStatus.ACCEPTED);
    }
    @PostMapping("/postuleroffre/{idoffre}/{idcondidat}")
    public  ResponseEntity<MessageResponse> Postuleroffre(@PathVariable(value="idoffre") Long idoffre,
                                                          @PathVariable(value ="idcondidat") Long idcondidat)
    {
        return service.postuleroffre(idoffre,idcondidat);
    }
    @DeleteMapping("/supprimernscritoffre/{id}")
    public  ResponseEntity<MessageResponse> Supprimerinscritoffre(@PathVariable(value="id") Long id )
    {
        return service.supprimerinscroffre(id);
    }
    @RequestMapping("/chercherinscritoffre/{cin}")
    public  ResponseEntity<List<OffrecondidatResponse>> Chercherinscritoffre(@PathVariable(value="cin") String cin)
    {
        return ResponseEntity.ok(service.Chercherinscriptionoffre(cin));
    }
    @GetMapping("/afficherinscroffreparmail/{mail}")
    public  ResponseEntity<List<OffrecondidatResponse>> Afficherinscriptoffreparmail(@PathVariable(value="mail")
                                                                         String mail)
    {
        return  ResponseEntity.ok(service.Afficherinscriptionoffreparmail(mail));
    }

    @PutMapping("/chagestatus/{id}/{status}")
       public ResponseEntity<MessageResponse> Statuspostuleoffre(@PathVariable(value="id") Long id
                                                       , @PathVariable(value="status") String status)
    {
        return service.Statuspostule(id,status);
    }
    @PostMapping("/chercherparnometprenom/{nom}/{prenom}")
    public ResponseEntity<List<OffrecondidatResponse>> Chercherparnometprenom(@PathVariable(value="nom") String nom,
                                                                              @PathVariable(value="prenom") String prenom)
    {
        return ResponseEntity.ok(service.Chercherinscitoffreparnometprenom(nom,prenom));
    }



}
