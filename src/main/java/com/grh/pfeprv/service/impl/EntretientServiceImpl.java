package com.grh.pfeprv.service.impl;


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
        mail.setTo(offreemploieCondidat.getCondidats().getEmail());
        //mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("RENDEZ VOUS ENTRETIENT");
        mail.setContent("Bonjour Monsieur/Madame"+" "+offreemploieCondidat.getCondidats().getPrenom()+" "+offreemploieCondidat.getCondidats().getNom()+" "+
                "nous avons le plaisir de vous inviter pour une rencontre à notre entreprise pour la date :"+" "+entretientRequest.getDate().toString()+ " à "+entretientRequest.getHeure()
        +"pour la demande de condidature "+" "+offreemploieCondidat.getOffreemploie().getTitredoffre()+"\r\n "+"Vous rencontrerez  au cours d’un entretien d’une demi-heure environ, pour discuter du poste à pourvoir et de votre parcours professionnel. L’interview sera suivie d’un test.\r\n"+" "
        +"Merci \r\n"
        +"Cordiallment");
        emailService.sendSimpleMessage(mail);

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
        mail.setTo(entretient1.getCondidat().getEmail());
        //mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("RESULTAT ENTRETIENT");

        if(status.equals("accepte"))
        {
            entretient1.setStatus(EStatusEntretient.ACCEPTE);
            mail.setContent("Félecitation Monsieur/Madame"+" "+entretient1.getCondidat().getPrenom()+" "+entretient1.getCondidat().getNom()+" "+
                   " "+"titulaire sous CIN: "+" "+entretient1.getCondidat().getCin() +" "+"pour la sucé dans l entretient pour la demande de condidature"+ " " +entretient1.getTitreOffre()
            +" "+"passé le " + " "+entretient1.getDate().toString()+" \r\n ."
                    +" priére de venir au sociéte pour plus de négociation"+" \r\n."
                    +"Merci"+"\r\n."
                    +"Cordiallment \r\n"+"BCIT"
            );
        }
        else
        {
            entretient1.setStatus(EStatusEntretient.REFUSE);
            mail.setContent("Nous sommes navré de vous informer Monsieur/Madame"+" " +entretient1.getCondidat().getPrenom()+" "+entretient1.getCondidat().getNom()
            +" "+" que vous n été pas accépte dans l entretient pour la demande de condidature de l'offre d'emploie "+" "+entretient1.getTitreOffre()+" "+ " passé le "+ entretient1.getDate().toString()+"\r\n."
            + "Merci pour votre compréhension " +"\r\n"+
            "Cordiallement\r\n"+"BCIT");
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
        mail.setTo(entretient1.getCondidat().getEmail());
        //mail.setTo("ahmed.zbidi1@esprit.tn");
        mail.setSubject("CHANGEMENT ENTRETIENT");
        mail.setContent("Monsieur/Madame"+" "+entretient1.getCondidat().getNom()+" "+entretient1.getCondidat().getPrenom()+" "+" nous informons qu il y a un changement dans l'horaire de l 'entretient pour la demande de condidature"+" "+entretient1.getTitreOffre()+" "+"qui sera passé le : "
        +" "+entretient1.getHeure()+" "+" pour la date"+" "+entretient1.getDate().toString()+" . \r\n"
        +"Merci\r\n"
        +"Cordiallement\r\n"+
                "BCIT");
        emailService.sendSimpleMessage(mail);
        return ResponseEntity.ok(new MessageResponse("entretient modifier avec succeé"));
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
