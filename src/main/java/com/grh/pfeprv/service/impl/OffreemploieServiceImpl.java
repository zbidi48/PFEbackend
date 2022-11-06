package com.grh.pfeprv.service.impl;
import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.OffreemploieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.OffeemploieRepository;
import com.grh.pfeprv.service.IOffreemploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OffreemploieServiceImpl implements IOffreemploieService {
    @Autowired
    OffeemploieRepository offeemploieRepository;

    @Override
    public List<Offreemploie> Afficheroffres() {
        return offeemploieRepository.findAll();
    }

    @Override
    public ResponseEntity<MessageResponse> Ajouteroffre(OffreemploieRequest offreemploieRequest) {
        Offreemploie offreemploie = new Offreemploie();
        offreemploie.setDatelimite(offreemploieRequest.getDatelimite());
        offreemploie.setDescription(offreemploieRequest.getDescription());
        offreemploie.setExigenceemploie(offreemploieRequest.getExigenceemploie());
        offreemploie.setLangue(offreemploieRequest.getLangue());
        offreemploie.setTitredoffre(offreemploieRequest.getTitredoffre());
        offreemploie.setExperience(offreemploieRequest.getExperience());
        offreemploie.setDatecreation(new Date());
        offeemploieRepository.save(offreemploie);
        return ResponseEntity.ok(new MessageResponse("ajout d offre emploie avec success !"));
    }

    @Override
    public ResponseEntity<MessageResponse> Miseajouroffre(Long id,
                                                          OffreemploieRequest offreemploieRequest) {
        Optional<Offreemploie> offreemploie = offeemploieRepository.findById(id);
        if(!offreemploie.isPresent())
        {
            throw new NotFoundException("offreemploie ID: " + id + " not found");
        }
        Offreemploie ofrempl= offreemploie.get();
        ofrempl.setDatelimite(offreemploieRequest.getDatelimite());
        ofrempl.setDescription(offreemploieRequest.getDescription());
        ofrempl.setExigenceemploie(offreemploieRequest.getExigenceemploie());
        ofrempl.setLangue(offreemploieRequest.getLangue());
        ofrempl.setTitredoffre(offreemploieRequest.getTitredoffre());
        ofrempl.setExperience(offreemploieRequest.getExperience());

        offeemploieRepository.save(ofrempl);

        return ResponseEntity.ok(new MessageResponse(" modification offre emploie avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Supprimeroffre(Long id) {
        Optional<Offreemploie> offre= offeemploieRepository.findById(id);
        if(!offre.isPresent())
        {
            throw new NotFoundException("offeemploie ID: " + id + " not found");
        }
        Offreemploie offreemploie= offre.get();
        offeemploieRepository.delete(offreemploie);
        return ResponseEntity.ok(new MessageResponse(" suppréssion offre emploie avec succeé"));
    }

    @Override
    public Offreemploie Detailoffre(Long id) {
        Optional<Offreemploie> offre= offeemploieRepository.findById(id);
        if(!offre.isPresent())
        {
            throw new NotFoundException("offeemploie ID: " + id + " not found");
        }
        Offreemploie offreemploie= offre.get();
        return offreemploie;
    }

    @Override
    public List<Offreemploie> rechercheoffer(String titredoffre) {

        return offeemploieRepository.findByTitredoffre(titredoffre);
    }


}
