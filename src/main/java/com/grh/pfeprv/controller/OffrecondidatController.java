package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.payloads.request.OffrecondidatRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.OffrecondidatResponse;
import com.grh.pfeprv.service.IOffeCondidatService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<OffrecondidatResponse> Afficherinscriptionoffre()
    {
        return service.Afficherinscriptionoffre();
    }
    @PutMapping("/miseajourinscript/{id}")
    public ResponseEntity<MessageResponse> Miseajourinscripoffre(@PathVariable(value="id")
                                                                     Long id,
                                                                 @RequestBody OffrecondidatRequest
                                                                         offrecondidatRequest)
    {
        return service.miseajourinscoffre(id,offrecondidatRequest);
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
    @RequestMapping("/chercherinscritoffre/{titredoffre}")
    public  List<OffrecondidatResponse> Chercherinscritoffre(@PathVariable(value="titredoffre") String titredoffre)
    {
        return service.Chercherinscriptionoffre(titredoffre);
    }
    @GetMapping("/afficherinscroffreparmail/{mail}")
    public  List<OffrecondidatResponse> Afficherinscriptoffreparmail(@PathVariable(value="mail")
                                                                         String mail)
    {
        return  service.Afficherinscriptionoffreparmail(mail);
    }
    @GetMapping("/detailinscriptoffre/{id}")
    public OffreemploieCondidat Detailinscriptoffre(@PathVariable(value="id") Long id)
    {
        return service.Afficherinscripparid(id);
    }
    @PutMapping("/chagestatus/{id}")
       public ResponseEntity<MessageResponse> Statuspostuleoffre(@PathVariable(value="id") Long id
                                                       , @RequestBody OffrecondidatRequest offrecondidatRequest)
    {
        return service.Statuspostule(id,offrecondidatRequest);
    }

    @GetMapping("/acceptentretient/{status}")
    public  List<OffrecondidatResponse>  Postuleaccepte(@PathVariable(value="status") String status)
    {
        return service.Affichercondidatentretient(status);
    }

}
