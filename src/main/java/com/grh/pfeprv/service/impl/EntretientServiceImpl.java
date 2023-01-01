package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Entretient;
import com.grh.pfeprv.enums.EStatusEntretient;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.EntretientRequest;
import com.grh.pfeprv.payloads.response.EntretientResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.repository.EntretientRepository;
import com.grh.pfeprv.service.IEntretientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EntretientServiceImpl implements IEntretientService {
    @Autowired
    CondidatRepository condidatRepository;
    @Autowired
    EntretientRepository entretientRepository;
    @Override
    public List<EntretientResponse> Afficherentretient() {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findAllBySupprIsFalse().forEach(entretient ->
        {
            responses.add(new EntretientResponse(
                    entretient.getId(),
                    entretient.getDate(),
                    entretient.getHeure(),
                    entretient.getStatus().name(),
                    entretient.getCondidat().getNom(),
                    entretient.getCondidat().getPrenom(),
                    entretient.getCondidat().getCin()
            ));
        });

        return responses;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajouterentretient(EntretientRequest entretientRequest) {
        Entretient entretient = new Entretient();
        Optional<Condidats> condidats = condidatRepository.findById(entretientRequest.getCondidats_id());
        if(!condidats.isPresent())
        {
            throw new NotFoundException("Ajout impossible");
        }
        Condidats condidat = condidats.get();
        entretient.setDate(entretientRequest.getDate());
        entretient.setHeure(entretientRequest.getHeure());
        entretient.setStatus(EStatusEntretient.ENCOUR);

        entretient.setSuppr(false);
        entretient.setCondidat(condidat);
        entretientRepository.save(entretient);
        return ResponseEntity.ok(new MessageResponse("entretient ajouter avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Miseajourentretient(Long id,
                                                               EntretientRequest entretientRequest) {
        Optional<Entretient> entretient = entretientRepository.findById(id);
        if (!entretient.isPresent())
        {
            throw new NotFoundException("entretient ID: " + id + " not found");
        }
        Entretient entretient1 = entretient.get();
        entretient1.setDate(entretientRequest.getDate());
        entretient1.setHeure(entretientRequest.getHeure());
        entretientRepository.save(entretient1);
        return ResponseEntity.ok(new MessageResponse("entretient modifier avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Supprimerentretient(Long id) {
        Optional<Entretient> entretient = entretientRepository.findById(id);
        if(!entretient.isPresent())
        {
            throw new NotFoundException("entretient ID: " + id + " not found");
        }
        Entretient entretient1 = entretient.get();
        entretient1.setSuppr(true);
        entretientRepository.save(entretient1);
        return ResponseEntity.ok(new MessageResponse("entretient supprimer avec success !"));
    }

    @Override
    public Entretient Detailentretient(Long id) {
        Optional<Entretient> entretient = entretientRepository.findById(id);
        if(!entretient.isPresent())
        {
            throw new NotFoundException("entretient ID: " + id + " not found");
        }
        return entretient.get();
    }

    @Override
    public List<EntretientResponse> Chercherentretient(String nom, String prenom) {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findByCondidat_NomAndCondidat_PrenomAndSupprIsFalse(nom, prenom).forEach(
                entretient -> {
                    responses.add(new EntretientResponse(
                            entretient.getId(),
                            entretient.getDate(),
                            entretient.getHeure(),
                            entretient.getStatus().name(),
                            entretient.getCondidat().getNom(),
                            entretient.getCondidat().getPrenom(),
                            entretient.getCondidat().getCin()
                    ));
                }
        );

        return responses;
    }

    @Override
    public List<EntretientResponse> chercherentretientparCIN(String cin) {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findAllByCondidat_CinAndSupprIsFalse(cin).forEach(
                entretient -> {
                    responses.add(new EntretientResponse(
                            entretient.getId(),
                            entretient.getDate(),
                            entretient.getHeure(),
                            entretient.getStatus().name(),
                            entretient.getCondidat().getNom(),
                            entretient.getCondidat().getPrenom(),
                            entretient.getCondidat().getCin()
                    ));
                }
        );

        return responses;
    }

    @Override
    public List<EntretientResponse> afficherentretientparmail(String email) {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findAllByCondidat_Email(email).forEach(
                entretient -> {
                    responses.add(new EntretientResponse(
                            entretient.getId(),
                            entretient.getDate(),
                            entretient.getHeure(),
                            entretient.getStatus().name(),
                            entretient.getCondidat().getNom(),
                            entretient.getCondidat().getPrenom(),
                            entretient.getCondidat().getCin()
                    ));
                }
        );
        return responses;
    }

    @Override
    public ResponseEntity<MessageResponse> accordentretient(Long id, String status) {
        Optional<Entretient> entretient = entretientRepository.findById(id);
        if (!entretient.isPresent())
        {
            throw new NotFoundException("entretient ID: " + id + " not found");
        }
        Entretient entretient1 = entretient.get();
        if(status.equals("accepte"))
        {
            entretient1.setStatus(EStatusEntretient.ACCEPTE);
        }
        else
        {
            entretient1.setStatus(EStatusEntretient.REFUSE);
        }
        entretientRepository.save(entretient1);

        return ResponseEntity.ok(new MessageResponse("accord entretient fait avec succé"));
    }

    @Override
    public List<EntretientResponse> chercher(String key) {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findAllByCondidat_NomOrCondidat_PrenomOrCondidat_CinAndSupprIsFalse(key,key,key).
                forEach(
                entretient -> {
                    responses.add(new EntretientResponse(
                            entretient.getId(),
                            entretient.getDate(),
                            entretient.getHeure(),
                            entretient.getStatus().name(),
                            entretient.getCondidat().getNom(),
                            entretient.getCondidat().getPrenom(),
                            entretient.getCondidat().getCin()
                    ));
                }
        );

        return responses;
    }
}
