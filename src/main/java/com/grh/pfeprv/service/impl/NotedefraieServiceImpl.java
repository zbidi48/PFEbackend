package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Notedefraie;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.NotedefraieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.NotedefraieResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.NotedefraieRepository;
import com.grh.pfeprv.service.INotedefraieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class NotedefraieServiceImpl implements INotedefraieService {
    @Autowired
    NotedefraieRepository notedefraieRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<NotedefraieResponse> Affichernotedefraie() {
        List<NotedefraieResponse> response = new ArrayList<>();
        notedefraieRepository.findAllBySupprimerIsFalse().forEach(notedefraie -> {
            response.add(new NotedefraieResponse(
                    notedefraie.getId(),
                    notedefraie.getDescription(),
                    notedefraie.getDatecreation(),
                    notedefraie.getFraie(),
                    notedefraie.getEmployee().getNom(),
                    notedefraie.getEmployee().getPrenom(),
                    notedefraie.getEmployee().getJobid()));
        });

        return response;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajoutnotedefraie(NotedefraieRequest notedefraieRequest) {
        Notedefraie notedefraie = new Notedefraie();
        Optional<Employee> employee = employeeRepository.findById(notedefraieRequest.getEmployee_id());
        if(!employee.isPresent())
        {
            throw new NotFoundException("Ajout impossible");
        }
        Employee employee1 = employee.get();
        notedefraie.setDatecreation(new Date());
        notedefraie.setDescription(notedefraieRequest.getDescription());

        notedefraie.setSupprimer(false);
        notedefraie.setFraie(notedefraieRequest.getFraie());
        notedefraie.setEmployee(employee1);
        notedefraieRepository.save(notedefraie);
        return ResponseEntity.ok(new MessageResponse("ajout avec success !"));
    }


    @Override
    public ResponseEntity<MessageResponse> Miseajournotedefraie(Long id,
                                                                NotedefraieRequest notedefraieRequest) {
        Optional<Notedefraie> notedefraie = notedefraieRepository.findById(id);
        if(!notedefraie.isPresent())
        {
            throw new NotFoundException("notedefraie ID: " + id + " not found");
        }
        Notedefraie notedefraie1 = notedefraie.get();
        notedefraie1.setDescription(notedefraieRequest.getDescription());
        notedefraie1.setFraie(notedefraieRequest.getFraie());
        notedefraieRepository.save(notedefraie1);
        return ResponseEntity.ok(new MessageResponse(" modification avec succeé"));
    }


    @Override
    public ResponseEntity<MessageResponse> Supprimernotedefraie(Long id) {
        Optional<Notedefraie> notedefraie = notedefraieRepository.findById(id);
        if (!notedefraie.isPresent()) {
            throw new NotFoundException("notedefraie ID: " + id + " not found");
        }
        Notedefraie notedefraie1 = notedefraie.get();
        notedefraie1.setSupprimer(true);
        notedefraieRepository.save(notedefraie1);

        return ResponseEntity.ok(new MessageResponse("suppression  avec succeé"));
    }
    @Override
    public List<NotedefraieResponse> Cherchernotedefraie(String jobid) {
        List<NotedefraieResponse> responses= new ArrayList<>();
        notedefraieRepository.findByEmployee_JobidAndAndSupprimerIsFalse(jobid).forEach(notedefraie ->
        {
            responses.add(new NotedefraieResponse(
                    notedefraie.getId(),
                    notedefraie.getDescription(),
                    notedefraie.getDatecreation(),
                    notedefraie.getFraie(),
                    notedefraie.getEmployee().getNom(),
                    notedefraie.getEmployee().getPrenom(),
                    notedefraie.getEmployee().getJobid()));
        });
        return responses;
    }

    @Override
    public Notedefraie Affichernotedefraieparid(Long id) {
        Optional<Notedefraie> notedefraie = notedefraieRepository.findById(id);
        if (!notedefraie.isPresent()) {
            throw new NotFoundException("notedefraie ID: " + id + " not found");
        }
        Notedefraie notedefraie1 = notedefraie.get();

        return notedefraie1;
    }

    @Override
    public List<NotedefraieResponse> Affichernotedefraieparmail(String email) {
        List<NotedefraieResponse> response = new ArrayList<>();
        notedefraieRepository.findByEmployee_Email(email).forEach(
                notedefraie -> {
                    response.add(new NotedefraieResponse(
                            notedefraie.getId(),
                            notedefraie.getDescription(),
                            notedefraie.getDatecreation(),
                            notedefraie.getFraie(),
                            notedefraie.getEmployee().getNom(),
                            notedefraie.getEmployee().getPrenom(),
                            notedefraie.getEmployee().getJobid()));
                });

        return response;
    }


}
