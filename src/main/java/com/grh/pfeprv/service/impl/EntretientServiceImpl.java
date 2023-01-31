package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Entretient;
import com.grh.pfeprv.domaine.Mail;
import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.enums.EStatusEntretient;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.EntretientRequest;
import com.grh.pfeprv.payloads.response.EntretientResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.repository.EntretientRepository;
import com.grh.pfeprv.repository.OffrecondidatRepository;
import com.grh.pfeprv.service.IEntretientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EntretientServiceImpl implements IEntretientService {
    @Autowired
    CondidatRepository condidatRepository;
    @Autowired
    EntretientRepository entretientRepository;
    @Autowired
    OffrecondidatRepository offrecondidatRepository;
    @Autowired
    EmailService emailService;
    @Override
    public List<EntretientResponse> Afficherentretient() {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.findAll().forEach(entretient ->
        {
            responses.add(new EntretientResponse(
                    entretient.getId(),
                    entretient.getDate(),
                    entretient.getHeure(),
                    entretient.getStatus().name(),
                    entretient.getCondidat().getNom(),
                    entretient.getCondidat().getPrenom(),
                    entretient.getTitreOffre()
            ));
        });

        return responses;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajouterentretient(EntretientRequest entretientRequest) {
        OffreemploieCondidat offreemploieCondidat = offrecondidatRepository.findById(entretientRequest
                .getInscritoffre_id()).get();
        Entretient entretient = new Entretient();
        entretient.setStatus(EStatusEntretient.ENCOUR);
        entretient.setDate(entretientRequest.getDate());
        entretient.setHeure(entretientRequest.getHeure());
        entretient.setTitreOffre(offreemploieCondidat.getOffreemploie().getTitredoffre());
        entretient.setCondidat(offreemploieCondidat.getCondidats());
        entretientRepository.save(entretient);
        offreemploieCondidat.setHasinterview(true);
        offrecondidatRepository.save(offreemploieCondidat);
        Mail mail = new Mail();
        mail.setFrom("jamilahalouas1955@gmail.com");
        //mail.setTo(offreemploieCondidat.getCondidats().getEmail());
        mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("RDV ENTRETIENT");
        mail.setContent(" Monsieur/Madame"+" "+offreemploieCondidat.getCondidats().getPrenom()+" "+offreemploieCondidat.getCondidats().getNom()+" "+
                "Votre RDV entrentient le :"+entretientRequest.getDate().toString()+ " à "+entretientRequest.getHeure()
        +"pour l offre"+" "+offreemploieCondidat.getOffreemploie().getTitredoffre()+"\r\n "+"Priére d etre 30min avant l horaire de rdv  \r\n"+" "
        +"Merci \r\n"
        +"Cordiallment");
        emailService.sendSimpleMessage(mail);
       /* Optional<Condidats> condidats = condidatRepository.findById(entretientRequest.getCondidats_id());
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
        entretientRepository.save(entretient);*/
        return ResponseEntity.ok(new MessageResponse("entretient ajouter avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> accordentretient(Long id, String status) {
        Optional<Entretient> entretient = entretientRepository.findById(id);
        if (!entretient.isPresent())
        {
            throw new NotFoundException("entretient ID: " + id + " not found");
        }
        Entretient entretient1 = entretient.get();
        Mail mail = new Mail();
        mail.setFrom("jamilahalouas1955@gmail.com");
       // mail.setTo(entretient1.getCondidat().getEmail());
        mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("RESULTAT ENTRETIENT");

        if(status.equals("accepte"))
        {
            entretient1.setStatus(EStatusEntretient.ACCEPTE);
            mail.setContent("Félecitation Monsieur/Madame"+" "+entretient1.getCondidat().getPrenom()+" "+entretient1.getCondidat().getNom()+" "+
                   " "+"titulaire sous carte identité nationale "+" "+entretient1.getCondidat().getCin() +" "+"pour la succé dans l entretient dans l offre"+ " " +entretient1.getTitreOffre()
            +" "+"passé le " + " "+entretient1.getDate().toString()+" \r\n ."
                    +" priére de venir au sociéte pour plus de négociation"+" \r\n."
                    +"Merci"+"\r\n."
                    +"Cordiallment"
            );
        }
        else
        {
            entretient1.setStatus(EStatusEntretient.REFUSE);
            mail.setContent("Nous sommes navré de vous informer"+" " +entretient1.getCondidat().getPrenom()+" "+entretient1.getCondidat().getNom()
            +" "+" que vous n éte pas accépte dans l entretient pour l offre "+" "+entretient1.getTitreOffre()+" "+ " passé le "+ entretient1.getDate().toString()+"\r\n."
            + "Merci pour votre compréhension " +"\r\n"+
            "Cordiallement");
        }
        entretientRepository.save(entretient1);
        emailService.sendSimpleMessage(mail);

        return ResponseEntity.ok(new MessageResponse("accord entretient fait avec succé"));
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
        Mail mail = new Mail();
        mail.setFrom("jamilahalouas1955@gmail.com");
        //mail.setTo(oentretient1.getCondidats().getEmail());
        mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("CHANGEMENT ENTRETIENT");
        mail.setContent("Monsieur/Madame"+" "+entretient1.getCondidat().getNom()+" "+entretient1.getCondidat().getPrenom()+" "+" nous informons qu il y a un changement d horaire de entretient "
        +" "+entretient1.getHeure()+" "+" pour la date"+entretient1.getDate().toString()+" \r\n."
        +"Merci\r\n"
        +"Cordiallement.");
        emailService.sendSimpleMessage(mail);
        return ResponseEntity.ok(new MessageResponse("entretient modifier avec succeé"));
    }

    /*
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

     */
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
    public List<EntretientResponse> chercher(String key) {
        List<EntretientResponse> responses = new ArrayList<>();
        entretientRepository.
                findAllByCondidat_NomOrCondidat_PrenomOrCondidat_Cin(key,key,key).
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
