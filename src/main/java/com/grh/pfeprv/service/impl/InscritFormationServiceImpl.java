package com.grh.pfeprv.service.impl;
import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Formation;
import com.grh.pfeprv.domaine.InscritFormation;
import com.grh.pfeprv.enums.EStatusInscritFormation;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.response.InscritFormationResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.FormationRepository;
import com.grh.pfeprv.repository.InscritFormationRepository;
import com.grh.pfeprv.service.InscritFormationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class InscritFormationServiceImpl implements InscritFormationService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    FormationRepository formationRepository;
    @Autowired
    InscritFormationRepository inscritFormationRepository;
    @Override
    public List<InscritFormationResponse> Afficherinscritformation() {
        List<InscritFormationResponse> responses = new ArrayList<>();
        inscritFormationRepository.findAllBySupprIsFalse().forEach(inscritFormation ->
        {
            responses.add(new InscritFormationResponse(
                    inscritFormation.getId(),
                    inscritFormation.getStatus(),
                    inscritFormation.getEmployee().getNom(),
                    inscritFormation.getEmployee().getPrenom(),
                    inscritFormation.getEmployee().getJobid(),
                    inscritFormation.getDateinscrit(),
                    inscritFormation.getFormation().getNomdeforamtion(),
                    inscritFormation.getFormation().getTypedeformation(),
                    inscritFormation.getFormation().getDatedebut(),
                    inscritFormation.getFormation().getHeure()
            ));
        });

        return responses;
    }

    @Override
    public ResponseEntity<MessageResponse> Inscritformation(Long idemployee,Long idformation) {
        InscritFormation inscritFormation = new InscritFormation();
        Optional<Employee> employee = employeeRepository.findById(idemployee);
        Optional<Formation> formation = formationRepository.findById(idformation);
        if(!employee.isPresent() && !formation.isPresent())
        {
            throw new NotFoundException("vous ne pouvez pas postuler ");
        }
        inscritFormation.setStatus(EStatusInscritFormation.ENCOUR);
        inscritFormation.setSuppr(false);
        inscritFormation.setDateinscrit(new Date());
        inscritFormation.setFormation(formation.get());
        inscritFormation.setEmployee(employee.get());
        inscritFormationRepository.save(inscritFormation);

        return ResponseEntity.ok(new MessageResponse("inscrit formation fait avec succé !"));
    }

    @Override
    public ResponseEntity<MessageResponse> Supprimerinscrit(Long id) {
        Optional<InscritFormation> inscritFormation = inscritFormationRepository.findById(id);
        if(!inscritFormation.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        InscritFormation inscritFormation1 =inscritFormation.get();

       inscritFormation1.setSuppr(true);
       inscritFormationRepository.save(inscritFormation1);

        return ResponseEntity.ok(new MessageResponse(" suppresion  avec succeé"));
    }

    @Override
    public ResponseEntity<InscritFormationResponse> Detailleinscritformation(Long id) {
       InscritFormationResponse response = new InscritFormationResponse();

        //InscritFormation inscritFormation = inscritFormationRepository.findById(id).get();

        Optional<InscritFormation> inscritFormation = inscritFormationRepository.findById(id);
        if(!inscritFormation.isPresent())
        {
            throw new NotFoundException("inscritformation ID: "+id+" not found");
        }
        response.setId(inscritFormation.get().getId());
        response.setStatus(inscritFormation.get().getStatus());
        response.setNom(inscritFormation.get().getEmployee().getNom());
        response.setPrenom(inscritFormation.get().getEmployee().getPrenom());
        response.setJobid(inscritFormation.get().getEmployee().getJobid());
        response.setNomdeforamtion(inscritFormation.get().getFormation().getNomdeforamtion());
        response.setTypedeformation(inscritFormation.get().getFormation().getTypedeformation());
        response.setDatedebut(inscritFormation.get().getFormation().getDatedebut());
        response.setHeure(inscritFormation.get().getFormation().getHeure());
        response.setDateinscrit(inscritFormation.get().getDateinscrit());
        return  ResponseEntity.ok(response);
    }
    @Override
    public List<InscritFormationResponse> Chercherinscritformationparjobid(String jobid) {
        List<InscritFormationResponse> responses = new ArrayList<>();
        inscritFormationRepository.findByEmployee_JobidAndSupprIsFalse(jobid).forEach(inscritFormation ->
        {
            responses.add(new InscritFormationResponse(
                    inscritFormation.getId(),
                    inscritFormation.getStatus(),
                    inscritFormation.getEmployee().getNom(),
                    inscritFormation.getEmployee().getPrenom(),
                    inscritFormation.getEmployee().getJobid(),
                    inscritFormation.getDateinscrit(),
                    inscritFormation.getFormation().getNomdeforamtion(),
                    inscritFormation.getFormation().getTypedeformation(),
                    inscritFormation.getFormation().getDatedebut(),
                    inscritFormation.getFormation().getHeure()
            ));
        });
        return responses;
    }


    @Override
    public List<InscritFormationResponse> Chercherinscritformationparnometprenom(String nom, String prenom) {
        List<InscritFormationResponse> responses = new ArrayList<>();
        inscritFormationRepository.findAllByEmployee_NomAndAndEmployee_PrenomAndAndSupprIsFalse(nom,prenom)
                .forEach(inscritFormation ->
        {
            responses.add(new InscritFormationResponse(
                    inscritFormation.getId(),
                    inscritFormation.getStatus(),
                    inscritFormation.getEmployee().getNom(),
                    inscritFormation.getEmployee().getPrenom(),
                    inscritFormation.getEmployee().getJobid(),
                    inscritFormation.getDateinscrit(),
                    inscritFormation.getFormation().getNomdeforamtion(),
                    inscritFormation.getFormation().getTypedeformation(),
                    inscritFormation.getFormation().getDatedebut(),
                    inscritFormation.getFormation().getHeure()
            ));
        });
        return responses;
    }


    @Override
    public ResponseEntity<MessageResponse> changersatus(Long id, String status) {
        Optional<InscritFormation> inscritFormation = inscritFormationRepository.findById(id);
        if(!inscritFormation.isPresent())
        {
            throw new NotFoundException("inscritformation ID: "+id+" not found");
        }
        InscritFormation inscritFormation1 = inscritFormation.get();
        if(status.equals("accepte")){
            inscritFormation1.setStatus(EStatusInscritFormation.ACCEPTE);

        } else {
            inscritFormation1.setStatus(EStatusInscritFormation.REFUSE);

        }
        inscritFormationRepository.save(inscritFormation1);

        return ResponseEntity.ok(new MessageResponse(" status modifier avec succeé"));
    }

    @Override
    public List<InscritFormationResponse> Afficherinscritformationparemployeeid(Long employeeid) {
        List<InscritFormationResponse> responses = new ArrayList<>();
        //System.out.println("employee id " +""+employeeid);
        inscritFormationRepository.findByEmployee_IdAndSupprIsFalse(employeeid).forEach(inscritFormation ->
        {
            responses.add(new InscritFormationResponse(
                    inscritFormation.getId(),
                    inscritFormation.getStatus(),
                    inscritFormation.getEmployee().getNom(),
                    inscritFormation.getEmployee().getPrenom(),
                    inscritFormation.getEmployee().getJobid(),
                    inscritFormation.getDateinscrit(),
                    inscritFormation.getFormation().getNomdeforamtion(),
                    inscritFormation.getFormation().getTypedeformation(),
                    inscritFormation.getFormation().getDatedebut(),
                    inscritFormation.getFormation().getHeure()
            ));
        });

        return responses;
    }
}
