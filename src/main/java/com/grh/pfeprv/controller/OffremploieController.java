package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.payloads.request.OffreemploieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IOffreemploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offreemploie")
@CrossOrigin("*")
public class OffremploieController {
    @Autowired
    IOffreemploieService iOffreemploieService;
    @GetMapping("/afficheroffre")
    public List<Offreemploie> AffOff()
    {
        return iOffreemploieService.Afficheroffres();
    }
    @PutMapping("/miseajouroffre/{id}")
    public ResponseEntity<MessageResponse> MAOffre(@PathVariable(value="id") Long id,
                                                   @RequestBody OffreemploieRequest offreemploieRequest)
    {
        return iOffreemploieService.Miseajouroffre(id,offreemploieRequest);
    }
    @PostMapping("/ajouteroffre")
    public ResponseEntity<MessageResponse> AjoutOffre(@RequestBody OffreemploieRequest offreemploieReques)
    {
        return  iOffreemploieService.Ajouteroffre(offreemploieReques);
    }
    @DeleteMapping("/effaceroffre/{id}")
    public ResponseEntity<MessageResponse> EffOffre(@PathVariable(value="id") Long id)
    {
        return iOffreemploieService.Supprimeroffre(id);
    }
    @RequestMapping("/chercheroffrepartype/{titredoffre}")
    public List<Offreemploie> chercheroffre( @PathVariable("titredoffre") String titredoffre)

    {
        return  iOffreemploieService.rechercheoffer(titredoffre);
    }
    @GetMapping("/detailoffre/{id}")
    public Offreemploie Detailoffre(@PathVariable(value="id") Long id)
    {
        return iOffreemploieService.Detailoffre(id);
    }

}
