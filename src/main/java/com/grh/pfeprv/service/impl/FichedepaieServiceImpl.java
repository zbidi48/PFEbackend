package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Fichedepaie;
import com.grh.pfeprv.domaine.User;

import java.io.*;

import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.FichdepaieRequest;
import com.grh.pfeprv.payloads.response.FichedepaieResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.FichedepaieRepository;
import com.grh.pfeprv.repository.UserRepository;
import com.grh.pfeprv.service.IFichedepaieservice;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;


@Service
public class FichedepaieServiceImpl implements IFichedepaieservice {

    @Autowired
    FichedepaieRepository fichedepaieRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Fichedepaie> affichagesimple() {
        return fichedepaieRepository.findAll();
    }

    @Override
    public List<FichedepaieResponse> Affichageficheuser() {
        List<FichedepaieResponse> responses = new ArrayList<>();
        fichedepaieRepository.findAllBySupprIsFalse().forEach(fichedepaie -> {
            responses.add(new FichedepaieResponse(
                    fichedepaie.getId(),
                    fichedepaie.getDate(),
                    fichedepaie.getSalairebrut(),
                    fichedepaie.getSalairenet(),
                    fichedepaie.getEmployee().getNom(),
                    fichedepaie.getEmployee().getPrenom(),
                    fichedepaie.getEmployee().getPost(),
                    fichedepaie.getEmployee().getJobid()
            ));

        });
        return responses;
    }

    @Override
    public ResponseEntity<MessageResponse> Ajoutfiche(FichdepaieRequest f) {
        Fichedepaie fichedepaie = new Fichedepaie();
        Optional<Employee> user = employeeRepository.findById(f.getEmployee_id());
        if (!user.isPresent()) {
            throw new NotFoundException("Ajout impossible");
        }
        Employee usr = user.get();
        fichedepaie.setDate(f.getDate());
        fichedepaie.setSalairebrut(f.getSalairebrut());
        fichedepaie.setSalairenet(f.getSalairenet());
        fichedepaie.setSuppr(false);
        fichedepaie.setEmployee(usr);
        fichedepaieRepository.save(fichedepaie);
        return ResponseEntity.ok(new MessageResponse("fichedepaie ajouter avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Miseajourfiche(Long id, FichdepaieRequest f) {
        Optional<Fichedepaie> fichedepaie = fichedepaieRepository.findById(id);
        if (!fichedepaie.isPresent()) {
            throw new NotFoundException("fichedepaie ID: " + id + " not found");
        }
        Fichedepaie fp = fichedepaie.get();
        fp.setDate(f.getDate());
        fp.setSalairenet(f.getSalairenet());
        fp.setSalairebrut(f.getSalairebrut());
        fichedepaieRepository.save(fp);

        return ResponseEntity.ok(new MessageResponse("fichdepaie modifier avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Effacerfiche(Long id) {
        Optional<Fichedepaie> fichedepaie = fichedepaieRepository.findById(id);
        if (!fichedepaie.isPresent()) {
            throw new NotFoundException("fichedepaie ID: " + id + " not found");
        }
        Fichedepaie fp = fichedepaie.get();
        fp.setSuppr(true);
        fichedepaieRepository.save(fp);



        return ResponseEntity.ok(new MessageResponse("suppression avec success !"));
    }

    @Override
    public List<FichedepaieResponse> Affichageuserid(Long id) {
        List<FichedepaieResponse> fichedepaieResponses = new ArrayList<>();
        fichedepaieRepository.findByEmployee_IdAndSupprIsFalse(id).forEach(fichedepaie -> {
            fichedepaieResponses.add(new FichedepaieResponse(
                    fichedepaie.getId(),
                    fichedepaie.getDate(),
                    fichedepaie.getSalairebrut(),
                    fichedepaie.getSalairenet(),
                    fichedepaie.getEmployee().getNom(),
                    fichedepaie.getEmployee().getPrenom(),
                    fichedepaie.getEmployee().getPost(),
                    fichedepaie.getEmployee().getJobid()));
        });
        return fichedepaieResponses;
    }

    @Override
    public Fichedepaie Detailfiche(Long id) {
        Optional<Fichedepaie> fichedepaie = fichedepaieRepository.findById(id);
        if (!fichedepaie.isPresent()) {
            throw new NotFoundException("fichedepaie ID: " + id + " not found");
        }

        return fichedepaie.get();
    }

    @Override
    public List<FichedepaieResponse> chercherficheparjobid(String jobid) {
        List<FichedepaieResponse> responses = new ArrayList<>();
        fichedepaieRepository.findByEmployee_JobidAndAndSupprIsFalse(jobid).forEach(fichedepaie -> {
            responses.add(new FichedepaieResponse(
                    fichedepaie.getId(),
                    fichedepaie.getDate(),
                    fichedepaie.getSalairebrut(),
                    fichedepaie.getSalairenet(),
                    fichedepaie.getEmployee().getNom(),
                    fichedepaie.getEmployee().getPrenom(),
                    fichedepaie.getEmployee().getPost(),
                    fichedepaie.getEmployee().getJobid()

            ));
        });
        return responses;

    }


/*
@Override
    public List<FichedepaieResponse> chercherfiche(String nom, String prenom) {
        List<FichedepaieResponse> responses = new ArrayList<>();
        fichedepaieRepository.findByEmployee_NomAndAndEmployee_Prenom(nom, prenom).forEach(fichedepaie -> {
            responses.add(
                    new FichedepaieResponse(
                            fichedepaie.getId(),
                            fichedepaie.getDate(),
                            fichedepaie.getSalairebrut(),
                            fichedepaie.getSalairenet(),
                            fichedepaie.getEmployee().getNom(),
                            fichedepaie.getEmployee().getPrenom(),
                            fichedepaie.getEmployee().getPost(),
                            fichedepaie.getEmployee().getJobid()
                           /*
                            fichedepaie.getUser().getNom(),
                            fichedepaie.getUser().getPrenom(),
                            fichedepaie.getUser().getPost()
                            */
    @Override
    public ResponseEntity<MessageResponse> exportfichedepaie(Long id,Long emplid) throws FileNotFoundException , JRException {

        String path = "C:\\Users\\ASUS\\IdeaProjects\\PFEbackend\\Fichedepaie\\";
        Optional<Fichedepaie> fichedepaie= fichedepaieRepository.findById(id);
        Optional<Employee> employee= employeeRepository.findById(emplid);
        if(!employee.isPresent() && !fichedepaie.isPresent())
        {
            throw new NotFoundException("fichedepaie ID: " + id + " not found"+"ou employeeid"+emplid+"not found");
        }
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("prenom", employee.get().getPrenom());
        parameters.put("nom", employee.get().getNom());
        parameters.put("jobid",employee.get().getJobid());
        parameters.put("post",employee.get().getPost());
        parameters.put("date", fichedepaie.get().getDate());
        parameters.put("salairenet", fichedepaie.get().getSalairenet());
        parameters.put("salairebrut", fichedepaie.get().getSalairebrut());
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:Fichedepaie.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//Fichedepaie.pdf");
        return ResponseEntity.ok(new MessageResponse("report generated in path : " +
                ":" +path +"fichdepaie"+ fichedepaie.get().getId()+".pdf"));
    }
}

