package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Contrat;

import com.grh.pfeprv.domaine.Employee;

import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.ContratRequest;
import com.grh.pfeprv.payloads.response.ContratResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.ContratRepository;
import com.grh.pfeprv.repository.EmployeeRepository;

import com.grh.pfeprv.service.IContratService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.*;

@Service
public class ContratServiceImpl  implements IContratService {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Contrat> Afiichagecontratsimple() {
        return  contratRepository.findAll();
    }

    @Override
    public List<ContratResponse> affichercontart() {

        List<ContratResponse> response = new ArrayList<>();
        contratRepository.findAllByDeletedIsFalse().forEach(contrat -> {
            response.add(new ContratResponse(
                    contrat.getId(),
                    contrat.getCode(),
                    contrat.getType(),
                    contrat.getDatedebut(),
                    contrat.getDatefin(),
                    contrat.getEmployee().getNom(),
                    contrat.getEmployee().getPrenom(),
                    contrat.getEmployee().getPost(),
                    contrat.getEmployee().getJobid(),
                    contrat.getUrl()

                    ));
        });

        return response ;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajoucontrat(ContratRequest c) {
        Contrat contrat = new Contrat();
        Optional<Employee> employee = employeeRepository.findById(c.getEmployee_id());
        if(!employee.isPresent())
        {
            throw new NotFoundException("Ajout impossible");
        }
        //User us = user.get();
        Employee emp= employee.get();
        contrat.setCode(c.getCode());
        //contrat.setLibelle(c.getLibelle());
        contrat.setType(c.getType());
        contrat.setDatedebut(c.getDatedebut());
        contrat.setDatefin(c.getDatefin());
        contrat.setEmployee(emp);
        contrat.setDeleted(false);
        contratRepository.save(contrat);


        return ResponseEntity.ok(new MessageResponse("ajout avec success !"));
    }

    @Override
    public ResponseEntity<MessageResponse> MAcontrat(Long id, ContratRequest c) {
        Optional<Contrat> contrat = contratRepository.findById(id);
        if (!contrat.isPresent()) {
            throw new NotFoundException("contrat ID: " + id + " not found");
        }
        Contrat con = contrat.get();
        con.setCode(c.getCode());
        con.setType(c.getType());
        con.setDatefin(c.getDatefin());
        con.setDatedebut(c.getDatedebut());
       contratRepository.save(con);
        return ResponseEntity.ok(new MessageResponse(" modification avec succeé"));
    }
    @Override
    public ResponseEntity<MessageResponse> Effcontrat(Long id) {
        Optional<Contrat> contrat = contratRepository.findById(id);
        if (!contrat.isPresent()) {
            throw new NotFoundException("contrat ID: " + id + " not found");
        }
        Contrat con = contrat.get();
        con.setDeleted(true);
       contratRepository.save(con);
       //contratRepository.delete(con);

        return ResponseEntity.ok(new MessageResponse("contrat supprimer avec succeé"));
    }

    @Override
    public Contrat Affcontratid(Long id) {

        Optional<Contrat> cont = contratRepository.findById(id);
        if (!cont.isPresent()) {
            throw new NotFoundException("contrat ID: " + id + " not found");
        }
        return cont.get();
    }

    @Override
    public List<ContratResponse> Cherchercontrat(String code) {
        List<ContratResponse> responses = new ArrayList<>();
        contratRepository.findAllByCodeAndDeletedIsFalse(code).forEach(contrat ->
        {
            responses.add(new ContratResponse(
                    contrat.getId(),
                    contrat.getCode(),
                    contrat.getType(),
                    contrat.getDatedebut(),
                    contrat.getDatefin(),
                    contrat.getEmployee().getNom(),
                    contrat.getEmployee().getPrenom(),
                    contrat.getEmployee().getPost(),
                    contrat.getEmployee().getJobid(),
                    contrat.getUrl()
            ));
        });

        return responses;

    }

    @Override
    public List<ContratResponse> rechercheparnometprenom(String nom, String prenom) {
        List<ContratResponse> responses = new ArrayList<>();
        contratRepository.findAllByEmployee_NomAndEmployee_PrenomAndAndDeletedIsFalse(nom,prenom).
                forEach(contrat ->
        {
            responses.add(new ContratResponse(
                    contrat.getId(),
                    contrat.getCode(),
                    contrat.getType(),
                    contrat.getDatedebut(),
                    contrat.getDatefin(),
                    contrat.getEmployee().getNom(),
                    contrat.getEmployee().getPrenom(),
                    contrat.getEmployee().getPost(),
                    contrat.getEmployee().getJobid(),
                    contrat.getUrl()
            ));
        });

        return responses;
    }

    @Override
    public ResponseEntity<List<ContratResponse>> Affichercontratparemplid(Long emplid) {
        List<ContratResponse> responses = new ArrayList<>();
        contratRepository.findAllByEmployee_IdAndDeletedIsFalse(emplid).forEach(contrat ->
        {
            responses.add(new ContratResponse(
                    contrat.getId(),
                    contrat.getCode(),
                    contrat.getType(),
                    contrat.getDatedebut(),
                    contrat.getDatefin(),
                    contrat.getEmployee().getNom(),
                    contrat.getEmployee().getPrenom(),
                    contrat.getEmployee().getPost(),
                    contrat.getEmployee().getJobid(),
                    contrat.getUrl()
            ));
        });

        return ResponseEntity.ok(responses);
    }

    @Override
    public List<ContratResponse> recherchecontratparjobid(String jobid) {
        List<ContratResponse> responses = new ArrayList<>();
        contratRepository.findAllByEmployee_JobidAndDeletedIsFalse(jobid).forEach(contrat ->
        {
            responses.add(new ContratResponse(
                    contrat.getId(),
                    contrat.getCode(),
                    contrat.getType(),
                    contrat.getDatedebut(),
                    contrat.getDatefin(),
                    contrat.getEmployee().getNom(),
                    contrat.getEmployee().getPrenom(),
                    contrat.getEmployee().getPost(),
                    contrat.getEmployee().getJobid(),
                    contrat.getUrl()
            ));
        });
        return  responses;
    }

    @Override
    public ResponseEntity<MessageResponse> exportcontratpdf(Long id, Long emplid) throws
            FileNotFoundException, JRException, MalformedURLException {
        //String path = "C:\\Users\\ASUS\\Downloads";
        String path = "C:\\Users\\ASUS\\IdeaProjects\\PFEbackend\\contrat\\";
        Contrat contrat = contratRepository.findById(id).get();

        Employee employee = employeeRepository.findById(emplid).get();

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codecontrat",contrat.getCode() );
        parameters.put("typecontrat",contrat.getType() );
       parameters.put("datedeb", contrat.getDatedebut());
        parameters.put("datefin",contrat.getDatefin() );
        parameters.put("nom", employee.getNom());
        parameters.put("prenom", employee.getPrenom());
        parameters.put("post",employee.getPost());
        parameters.put("jobid",employee.getJobid());
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:contrat.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, path +"contrat_"+ employee.getId()+".pdf");

       contrat.setUrl( "C:\\Users\\ASUS\\IdeaProjects\\PFEbackend\\contrat\\" +"contrat_"+ employee.getId()+".pdf");

        contratRepository.save(contrat);
        return ResponseEntity.ok(new MessageResponse("contrat génerer sous format pdf dans le path " +
                ":" +path +"contrat_"+ employee.getId()+".pdf"));
    }
}
