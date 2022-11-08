package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.enums.EStatusOffreCondidat;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.OffrecondidatRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.OffrecondidatResponse;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.repository.OffeemploieRepository;
import com.grh.pfeprv.repository.OffrecondidatRepository;
import com.grh.pfeprv.service.IOffeCondidatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OffreCondidatServiceImpl implements IOffeCondidatService {
    @Autowired
    OffrecondidatRepository offrecondidatRepository;
    @Autowired
    CondidatRepository condidatRepository;
    @Autowired
    OffeemploieRepository offeemploieRepository;



    @Override
    public List<OffrecondidatResponse> Afficherinscriptionoffre() {
        List<OffrecondidatResponse> responses= new ArrayList<>();
        offrecondidatRepository.findAll().forEach(offreemploieCondidat -> {
            responses.add(new OffrecondidatResponse(
                    offreemploieCondidat.getId(),
                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                    offreemploieCondidat.getCondidats().getNom(),
                    offreemploieCondidat.getCondidats().getPrenom(),
                    offreemploieCondidat.getCondidats().getPost()));

        });
        return responses;
    }
    //changement au niveau de methode postuler au lieux de request on passe idoffre,idcandidat tout cour

    @Override
    public ResponseEntity<MessageResponse> postuleroffre(Long idoffre,Long idcondidat) {
        OffreemploieCondidat offreemploieCondidat = new OffreemploieCondidat();
        //System.out.println("idcondidat"+offrecondidatRequest.getCondidats_id());
        Optional<Condidats> condidats = condidatRepository.findById(idcondidat);
        //System.out.println("idoffre"+offrecondidatRequest.getOffreemploie_id());
        Optional<Offreemploie> offreemploie =offeemploieRepository.findById(idoffre);
        if(!condidats.isPresent() && !offreemploie.isPresent())
        {
            throw new NotFoundException("vous ne pouvez pas postuler");
        }
        Condidats condidats1 = condidats.get();
        Offreemploie offreemploie1 =offreemploie.get();
        offreemploieCondidat.setStatus(EStatusOffreCondidat.ENCOUR);
        offreemploieCondidat.setDatecreation(new Date());
        offreemploieCondidat.setCondidats(condidats1);
        offreemploieCondidat.setOffreemploie(offreemploie1);
        offrecondidatRepository.save(offreemploieCondidat);

        return ResponseEntity.ok(new MessageResponse("offre postuler avec succé !"));
    }

    @Override
    public ResponseEntity<MessageResponse> miseajourinscoffre(Long id, OffrecondidatRequest offrecondidatRequest) {
          Optional<OffreemploieCondidat> offreemploieCondidat=offrecondidatRepository.
                  findById(id);
          if(!offreemploieCondidat.isPresent())
          {
              throw new NotFoundException("inscripttion offre ID: " + id + " not found");
          }
          OffreemploieCondidat offreemploieCondidat1= offreemploieCondidat.get();


          offrecondidatRepository.save(offreemploieCondidat1);
        return ResponseEntity.ok(new MessageResponse(" modification avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> supprimerinscroffre(Long id) {
        Optional<OffreemploieCondidat> offreemploieCondidat=offrecondidatRepository.findById(id);
        if(!offreemploieCondidat.isPresent())
        {
            throw new NotFoundException("inscrition offre ID: " + id + " not found");
        }
        OffreemploieCondidat offreemploieCondidat1 =offreemploieCondidat.get();
        offrecondidatRepository.delete(offreemploieCondidat1);
        return ResponseEntity.ok(new MessageResponse(" suppresion d inscription d offre avec succeé"));
    }

    @Override
    public OffreemploieCondidat Afficherinscripparid(Long id) {


        Optional<OffreemploieCondidat> offreemploieCondidat=offrecondidatRepository.findById(id);
        if(!offreemploieCondidat.isPresent())
        {
            throw new NotFoundException("inscrition offre ID: " + id + " not found");
        }
        return offreemploieCondidat.get();

    }

    @Override
    public List<OffrecondidatResponse> Chercherinscriptionoffre(String titredoffre) {
        List<OffrecondidatResponse> response=new ArrayList<>();
        offrecondidatRepository.findByOffreemploie_Titredoffre(titredoffre).forEach(
                offreemploieCondidat -> {
                    response.add(
                            new OffrecondidatResponse(
                                    offreemploieCondidat.getId(),
                                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                                    offreemploieCondidat.getCondidats().getNom(),
                                    offreemploieCondidat.getCondidats().getPrenom(),
                                    offreemploieCondidat.getCondidats().getPost()));
                });

        return response;
    }

    @Override
    public List<OffrecondidatResponse> Afficherinscriptionoffreparmail(String mail) {
        List<OffrecondidatResponse> response=new ArrayList<>();
        offrecondidatRepository.findByCondidats_Email(mail).forEach(offreemploieCondidat -> {
            response.add(new OffrecondidatResponse(
                    offreemploieCondidat.getId(),
                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                    offreemploieCondidat.getCondidats().getNom(),
                    offreemploieCondidat.getCondidats().getPrenom(),
                    offreemploieCondidat.getCondidats().getPost()

                  ));
        });
        return response;
    }


    @Override
    public List<OffrecondidatResponse> Affichercondidatentretient(String status) {
        List<OffrecondidatResponse> responses= new ArrayList<>();
        offrecondidatRepository.findByStatus(status).forEach(offreemploieCondidat -> {
            responses.add(new OffrecondidatResponse(
                    offreemploieCondidat.getId(),
                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                    offreemploieCondidat.getCondidats().getNom(),
                    offreemploieCondidat.getCondidats().getPrenom(),
                    offreemploieCondidat.getCondidats().getPost()
            ));
        });
        return responses;
    }


    @Override
    public ResponseEntity<MessageResponse> Statuspostule(Long id, OffrecondidatRequest offrecondidatRequest) {
         Optional<OffreemploieCondidat> offreemploieCondidat = offrecondidatRepository.findById(id);
         if(!offreemploieCondidat.isPresent())
         {
             throw new NotFoundException("postuleoffre ID: "+id+" not found");
         }
         OffreemploieCondidat offreemploieCondidat1 =offreemploieCondidat.get();
         offreemploieCondidat1.setStatus(offrecondidatRequest.getStatus());
        offrecondidatRepository.save(offreemploieCondidat1);
        return ResponseEntity.ok(new MessageResponse("etat postuleoffre changé "));
    }
}
