package com.grh.pfeprv.service.impl;


import com.grh.pfeprv.domaine.Presence;
import com.grh.pfeprv.domaine.User;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.PresenceRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.PresenceResponse;
import com.grh.pfeprv.repository.PresenceRepository;
import com.grh.pfeprv.repository.UserRepository;
import com.grh.pfeprv.service.IPresenceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PresenceServiceImpl implements IPresenceService {
    @Autowired
    PresenceRepository presenceRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Presence> AffPresence() {

        return presenceRepository.findAll();
    }

    @Override
    public ResponseEntity<MessageResponse> Ajouprsence(PresenceRequest pr) {
        Presence presence = new Presence();
        Optional<User> user = userRepository.findById(pr.getUser_id());
        if(!user.isPresent())
        {

            throw new NotFoundException("Ajout impossible");
        }
        User us = user.get();
        presence.setDate(pr.getDate());
        presence.setNbreheure(pr.getNbreheure());
        presence.setUser(us);
        presenceRepository.save(presence);
        return   ResponseEntity.ok(new MessageResponse("presence ajouter avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> MAPresence(Long id, PresenceRequest pr) {
        Optional<Presence> presence= presenceRepository.findById(id);
        if(!presence.isPresent())
        {
            throw new NotFoundException("presence ID: "+id+" not found");
        }
        Presence prs = presence.get();
        prs.setDate(pr.getDate());
        prs.setNbreheure(pr.getNbreheure());
        presenceRepository.save(prs);

        return   ResponseEntity.ok(new MessageResponse("presence modifier avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> EffPresence(Long id) {
        Optional<Presence> presence= presenceRepository.findById(id);
        if(!presence.isPresent())
        {
            throw new NotFoundException("presence ID: "+id+" not found");
        }
        Presence prs = presence.get();
        presenceRepository.delete(prs);
        return ResponseEntity.ok(new MessageResponse("suppression avec success !"));

      
    }

    @Override
    public Presence AffPresencebyid(Long id) {

        Optional<Presence> prs= this.presenceRepository.findById(id);
        if (!prs.isPresent())
        {
            throw new NotFoundException("presence ID: " + id + " not found");
        }
        Presence pr=prs.get();
        return pr;
    }

    @Override
    public List<PresenceResponse> Affpresencebyuser(Long id) {
        List<PresenceResponse> response = new ArrayList<>();
        presenceRepository.findAllByUser_Id(id).forEach(presence -> {
            response.add(new PresenceResponse(
                    presence.getId(),
                    presence.getDate(),
                    presence.getNbreheure(),
                    presence.getUser().getNom(),
                    presence.getUser().getPrenom()));
        });

        return response;
    }

    @Override
    public List<PresenceResponse> Affpresencebyusermail(String email) {
        List<PresenceResponse> response = new ArrayList<>();
        presenceRepository.findAllByUser_Email(email).forEach(presence -> {
            response.add(new PresenceResponse(
                    presence.getId(),
                    presence.getDate(),
                    presence.getNbreheure(),
                    presence.getUser().getNom(),
                    presence.getUser().getPrenom()));

        });
        return response;
    }
}
