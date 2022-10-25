package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Formation;

import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.FormationRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.FormationRepository;
import com.grh.pfeprv.repository.UserRepository;
import com.grh.pfeprv.service.IFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FormationServiceImpl implements IFormationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FormationRepository formationRepository;


    @Override
    public ResponseEntity<List<Formation>> AffForm() {
        return new ResponseEntity(formationRepository.findAll(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<MessageResponse> AjouForm(FormationRequest fr) {
        Formation formation = new Formation();
        formation.setNomdeforamtion(fr.getNomdeforamtion());

        formation.setTypedeformation(fr.getTypedeformation());
       formationRepository.save(formation);


        return ResponseEntity.ok(new MessageResponse("ajout avec success !"));
    }


    @Override
    public ResponseEntity<MessageResponse> MAForm(Long id, FormationRequest fr) {
        Optional<Formation> formation = formationRepository.findById(id);
        if (!formation.isPresent()) {
            throw new NotFoundException("Formation ID: " + id + " not found");
        }
        Formation form = formation.get();
        form.setNomdeforamtion(fr.getNomdeforamtion());

        form.setTypedeformation(fr.getTypedeformation());
        formationRepository.save(form);


        return ResponseEntity.ok(new MessageResponse(" modification avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> EffForma(Long id) {
        Optional<Formation> formation = formationRepository.findById(id);
        if (!formation.isPresent()) {
            throw new NotFoundException("Formation ID: " + id + " not found");
        }
        Formation form = formation.get();
        formationRepository.delete(form);
        return ResponseEntity.ok(new MessageResponse("formation supprimer avec succeé"));
    }

    @Override
    public List<Formation> RechercheFormation(String typeformation) {

        return formationRepository.findByTypedeformation(typeformation);
    }

    @Override
    public Formation AffFormid(Long id) {

        Optional<Formation> forma = formationRepository.findById(id);
        if(! forma.isPresent())
        {
            throw new NotFoundException("Formation ID: " + id + " not found");
        }
         Formation form = forma.get();
        return  form;
    }
}
