package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.enums.EStatusOffreCondidat;
import com.grh.pfeprv.enums.EStatusVisa;
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

import java.sql.Date;
import java.util.ArrayList;
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
        offrecondidatRepository.findBySupprIsFalse().forEach(offreemploieCondidat -> {
            responses.add(new OffrecondidatResponse(
                    offreemploieCondidat.getId(),
                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                    offreemploieCondidat.getCondidats().getNom(),
                    offreemploieCondidat.getCondidats().getPrenom(),
                    offreemploieCondidat.getCondidats().getCin(),
                    offreemploieCondidat.getCondidats().getPost(),
                    offreemploieCondidat.getOffreemploie().getTitredoffre(),
                    offreemploieCondidat.getOffreemploie().getDescription(),
                    offreemploieCondidat.getOffreemploie().getDatelimite(),
                    offreemploieCondidat.getOffreemploie().getLangue(),
                    offreemploieCondidat.getOffreemploie().getExperience(),
                    offreemploieCondidat.getOffreemploie().getExigenceemploie(),
                    offreemploieCondidat.getStatus().name(),
                    offreemploieCondidat.getHasinterview()
            ));


        });
        return responses;
    }
    //changement au niveau de methode postuler au lieux de request on passe idoffre,idcandidat tout cour

    @Override
    public ResponseEntity<MessageResponse> postuleroffre(Long idoffre,Long idcondidat) {
        OffreemploieCondidat offreemploieCondidat = new OffreemploieCondidat();
        long miliseconds = System.currentTimeMillis();
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
        offreemploieCondidat.setHasinterview(false);
        offreemploieCondidat.setDatecreation(new Date(miliseconds));
        offreemploieCondidat.setSuppr(false);
        offreemploieCondidat.setCondidats(condidats1);
        offreemploieCondidat.setOffreemploie(offreemploie1);
        offrecondidatRepository.save(offreemploieCondidat);

        return ResponseEntity.ok(new MessageResponse("offre postuler avec succé !"));
    }



    @Override
    public ResponseEntity<MessageResponse> supprimerinscroffre(Long id) {
        Optional<OffreemploieCondidat> offreemploieCondidat=offrecondidatRepository.findById(id);
        if(!offreemploieCondidat.isPresent())
        {
            throw new NotFoundException("inscrition offre ID: " + id + " not found");
        }
        OffreemploieCondidat offreemploieCondidat1 =offreemploieCondidat.get();
        offreemploieCondidat1.setSuppr(true);
        offrecondidatRepository.save(offreemploieCondidat1);
        return ResponseEntity.ok(new MessageResponse(" suppresion d inscription d offre avec succeé"));
    }

    @Override
    public OffrecondidatResponse Afficherinscripparid(Long id) {
        OffrecondidatResponse response = new OffrecondidatResponse();
        Optional<OffreemploieCondidat> offreemploieCondidat= offrecondidatRepository.findById(id);
        if(!offreemploieCondidat.isPresent())
        {
            throw new NotFoundException("inscrition offre ID: " + id + " not found");
        }
        response.setId(offreemploieCondidat.get().getId());
        response.setDatecreation(offreemploieCondidat.get().getDatecreation());
        response.setNom(offreemploieCondidat.get().getCondidats().getNom());
        response.setPrenom(offreemploieCondidat.get().getCondidats().getPrenom());
        response.setCin(offreemploieCondidat.get().getCondidats().getCin());
        response.setPoste(offreemploieCondidat.get().getCondidats().getPost());
        response.setTitredoffre(offreemploieCondidat.get().getOffreemploie().getTitredoffre());
        response.setDescription(offreemploieCondidat.get().getOffreemploie().getDescription());
        response.setDatelimite(offreemploieCondidat.get().getOffreemploie().getDatelimite());
        response.setLangue(offreemploieCondidat.get().getOffreemploie().getLangue());
        response.setExperience(offreemploieCondidat.get().getOffreemploie().getExperience());
        response.setExigenceemploie(offreemploieCondidat.get().getOffreemploie().getExigenceemploie());
        response.setStatus(offreemploieCondidat.get().getStatus().name());

        return response;
    }


    @Override
    public List<OffrecondidatResponse> Chercherinscriptionoffre(String cin) {
        List<OffrecondidatResponse> response=new ArrayList<>();
        offrecondidatRepository.findAllByCondidats_Cin(cin).forEach(
                offreemploieCondidat -> {
                    response.add(
                            new OffrecondidatResponse(
                                    offreemploieCondidat.getId(),
                                    offreemploieCondidat.getOffreemploie().getDatecreation(),
                                    offreemploieCondidat.getCondidats().getNom(),
                                    offreemploieCondidat.getCondidats().getPrenom(),
                                    offreemploieCondidat.getCondidats().getCin(),
                                    offreemploieCondidat.getCondidats().getPost(),
                                    offreemploieCondidat.getOffreemploie().getTitredoffre(),
                                    offreemploieCondidat.getOffreemploie().getDescription(),
                                    offreemploieCondidat.getOffreemploie().getDatelimite(),
                                    offreemploieCondidat.getOffreemploie().getLangue(),
                                    offreemploieCondidat.getOffreemploie().getExperience(),
                                    offreemploieCondidat.getOffreemploie().getExigenceemploie(),
                                    offreemploieCondidat.getStatus().name(),
                                    offreemploieCondidat.getHasinterview()
                                    ));
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
                    offreemploieCondidat.getCondidats().getCin(),
                    offreemploieCondidat.getCondidats().getPost(),
                    offreemploieCondidat.getOffreemploie().getTitredoffre(),
                    offreemploieCondidat.getOffreemploie().getDescription(),
                    offreemploieCondidat.getOffreemploie().getDatelimite(),
                    offreemploieCondidat.getOffreemploie().getLangue(),
                    offreemploieCondidat.getOffreemploie().getExperience(),
                    offreemploieCondidat.getOffreemploie().getExigenceemploie(),
                    offreemploieCondidat.getStatus().name(),
                    offreemploieCondidat.getHasinterview()

                  ));
        });
        return response;
    }





    @Override
    public ResponseEntity<MessageResponse> Statuspostule(Long id, String status) {
         Optional<OffreemploieCondidat> offreemploieCondidat = offrecondidatRepository.findById(id);
         if(!offreemploieCondidat.isPresent())
         {
             throw new NotFoundException("postuleoffre ID: "+id+" not found");
         }
         OffreemploieCondidat offreemploieCondidat1 =offreemploieCondidat.get();
        if(status.equals("accepte")){
            offreemploieCondidat1.setStatus(EStatusOffreCondidat.ACCEPTE);
        } else {
            offreemploieCondidat1.setStatus(EStatusOffreCondidat.REFUSE);
        }

        offrecondidatRepository.save(offreemploieCondidat1);
        return ResponseEntity.ok(new MessageResponse("etat postuleoffre changé "));
    }



    @Override
    public List<OffrecondidatResponse> chercher(String query) {
        List<OffrecondidatResponse> response=new ArrayList<>();
        offrecondidatRepository.
   findAllByCondidats_NomAndSupprIsFalseOrCondidats_PrenomAndSupprIsFalseOrCondidats_CinAndSupprIsFalse(query,query,query).
                forEach(offreemploieCondidat -> {
                    response.add(new OffrecondidatResponse(
                            offreemploieCondidat.getId(),
                            offreemploieCondidat.getOffreemploie().getDatecreation(),
                            offreemploieCondidat.getCondidats().getNom(),
                            offreemploieCondidat.getCondidats().getPrenom(),
                            offreemploieCondidat.getCondidats().getCin(),
                            offreemploieCondidat.getCondidats().getPost(),
                            offreemploieCondidat.getOffreemploie().getTitredoffre(),
                            offreemploieCondidat.getOffreemploie().getDescription(),
                            offreemploieCondidat.getOffreemploie().getDatelimite(),
                            offreemploieCondidat.getOffreemploie().getLangue(),
                            offreemploieCondidat.getOffreemploie().getExperience(),
                            offreemploieCondidat.getOffreemploie().getExigenceemploie(),
                            offreemploieCondidat.getStatus().name(),
                            offreemploieCondidat.getHasinterview()

                    ));
                });
        return response;
    }
}
