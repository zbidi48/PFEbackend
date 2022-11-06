package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Visa;
import com.grh.pfeprv.enums.EStatusVisa;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.VisaRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.VisaResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.VisaRepository;
import com.grh.pfeprv.service.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class VisaServiceImpl implements IVisaService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    VisaRepository visaRepository;
    @Override
    public List<VisaResponse> Affichervisa() {
        List<VisaResponse> visaResponses = new ArrayList<>();
        visaRepository.findAllBySupprIsFalse().forEach(visa -> {
            visaResponses.add(new VisaResponse(
                    visa.getId(),
                    visa.getDatedepot(),
                    visa.getStatus().name(),
                    visa.getTypevisa(),
                    visa.getEmployee().getNom(),
                    visa.getEmployee().getPrenom(),
                    visa.getEmployee().getPost(),
                    visa.getEmployee().getJobid()));
        });
        return visaResponses;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajoutervisa(VisaRequest visaRequest) {
        Visa visa = new Visa();
       Optional<Employee> employee=employeeRepository.findById(visaRequest.getEmployee_id());
       if(!employee.isPresent())
       {
           throw new NotFoundException("Ajout impossible");
       }
       Employee employee1 = employee.get();
       visa.setDatedepot(visaRequest.getDatedepot());
       visa.setStatus(EStatusVisa.ENCOUR);
       visa.setTypevisa(visaRequest.getTypevisa());
       visa.setSuppr(false);
       visa.setEmployee(employee1);
       visaRepository.save(visa);
        return ResponseEntity.ok(new MessageResponse("visa ajouter avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Miseajourvisa(Long id, VisaRequest visaRequest) {
        Optional<Visa> visa = visaRepository.findById(id);
        //Optional<Employee> employee=employeeRepository.findById(visaRequest.getEmployee_id());
        if(!visa.isPresent())
        {
            throw new NotFoundException("visa ID: " + id + " not found");
        }
        Visa visa1 = visa.get();
        visa1.setDatedepot(visaRequest.getDatedepot());
        visa1.setStatus(EStatusVisa.ENCOUR);
        visa1.setTypevisa(visaRequest.getTypevisa());
        visa1.setSuppr(false);
       visaRepository.save(visa1);

        return   ResponseEntity.ok(new MessageResponse("visa modifier avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Supprimervisa(Long id) {
        Optional<Visa> visa = visaRepository.findById(id);
        if(!visa.isPresent())
        {
            throw new NotFoundException("visa ID: " + id + " not found");
        }
        Visa visa1 = visa.get();
        visa1.setSuppr(true);
        visaRepository.save(visa1);
        return ResponseEntity.ok(new MessageResponse("suppression  avec succeé"));
    }

    @Override
    public Visa Detailvisa(Long id) {
        Optional<Visa> visa = visaRepository.findById(id);
        if (!visa.isPresent())
        {
            throw new NotFoundException("visa ID: " + id + " not found");
        }


        return visa.get();
    }

    @Override
    public ResponseEntity<MessageResponse> Accordvisa(Long id,String status) {
        Optional<Visa> visa = visaRepository.findById(id);
        if(!visa.isPresent())
        {
            throw new NotFoundException("visa ID: "+id+" not found");
        }
        Visa visa1 = visa.get();
        if(status.equals("accepte")){
            visa1.setStatus(EStatusVisa.ACCEPTE);
        } else {
            visa1.setStatus(EStatusVisa.REFUSE);
        }

        visaRepository.save(visa1);
        return ResponseEntity.ok(new MessageResponse("visa congé valide"));
    }

    @Override
    public List<VisaResponse> affichervisaparmail(String email) {
        List<VisaResponse> visaResponses = new ArrayList<>();
        visaRepository.findByEmployee_Email(email).forEach(
                visa -> {
                    visaResponses.add(new VisaResponse(
                            visa.getId(),
                            visa.getDatedepot(),
                            visa.getStatus().name(),
                            visa.getTypevisa(),
                            visa.getEmployee().getNom(),
                            visa.getEmployee().getPrenom(),
                            visa.getEmployee().getPost(),
                            visa.getEmployee().getJobid()
                    ));
                }
        );

        return visaResponses;
    }

    @Override
    public List<VisaResponse> Cherchervisa(String jobid) {
        List<VisaResponse> visaResponses = new ArrayList<>();
        visaRepository.findByEmployee_JobidAndAndSupprIsFalse(jobid).forEach(visa -> {
            visaResponses.add(new VisaResponse(
                    visa.getId(),
                    visa.getDatedepot(),
                    visa.getStatus().name(),
                    visa.getTypevisa(),
                    visa.getEmployee().getNom(),
                    visa.getEmployee().getPrenom(),
                    visa.getEmployee().getPost(),
                    visa.getEmployee().getJobid()));
        });
        return visaResponses;
    }
}
