package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Mail;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/mailsend")
@CrossOrigin("*")
public class EmailController {
    @Autowired
     EmailService emailService;
    @Autowired
    CondidatRepository condidatRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/sendConfirmMessage/{id}")
    public String sendConfirmMessage(@PathVariable("id") Long id) {

        Optional<Condidats> candidat = condidatRepository.findById(id);
        Mail mail = new Mail();
        mail.setFrom("dminrh848@gmail.com");
        mail.setTo(candidat.get().getEmail());
        mail.setSubject("Invitation to interview at BCIT");
        mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" +
                "\r\n" +
                "Thank you for applying to BCIT.\r\n" +
                "\r\n" +
                "Your application for the position stood out to us and we would like to invite you for an interview at our office.\r\n" +
                "\r\n" +
                "We would like to conduct your interview sometime the week after Eid Holidays. \r\n" +
                "\r\n" +
                "I will be sending you a calendar invitation once I receive the disponibility calendar of the managers.\r\n" +
                "\r\n" +
                "If you have any questions or need additional information, " +
                "please don’t hesitate to contact me by telephone or email.\r\n" +
                "\r\n" +
                "\r\n" +
                "\r\n" +
                "best regards,");
        emailService.sendSimpleMessage(mail);
        return "message sent successffully";

    }
    @GetMapping("/sendDenyMessage/{id}")
    public String sendDenyMessage(@PathVariable("id") Long id) {

        Optional<Condidats> candidat = condidatRepository.findById(id);
        Mail mail = new Mail();
        mail.setFrom("dminrh848@gmail.com");
        mail.setTo(candidat.get().getEmail());
        mail.setSubject("Reply for your application at GRH");
        mail.setContent("Dear "+candidat.get().getPrenom()+","+"\r\n" +
                "\r\n" +
                "Thank you for applying to BCIT.\r\n" +
                "\r\n" +
                "Following the examination of your application, we regret to inform you that we cannot give a favorable result.\r\n" +
                "\r\n" +
                "We will of course keep your file and we will not fail to contact you if, however, an opportunity arises.\r\n" +
                "\r\n" +
                "We hope that your research will be completed quickly, and we ask you to accept the expression of our best regards.\r\n" +
                "\r\n" +
                "best regards,");
        emailService.sendSimpleMessage(mail);
        return "message sent successffully";

    }
    @GetMapping("/envoieconfirmmeet/{id}")
    public ResponseEntity<MessageResponse> Confirmemailmeet(@PathVariable("id") Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        Mail mail = new Mail();
        mail.setFrom("dminrh848@gmail.com");
        mail.setTo(employee.get().getEmail());
        mail.setSubject(" reminds for meeting ");
        mail.setContent("Dear "+employee.get().getPrenom()+""+employee.get().getNom()+","+"\r\n" +
                "\r\n" +
                "Thank you for to consult your menu meet in your account \r\n" +
                "if the meeting is online you find the link  of meeting \r\n" +
                " else the meting is face to face  \r\n" +
                " Please you respect the hour and be punctual \r\n" +
                " thank you \r\n" +
                "Cordially,");
        emailService.sendSimpleMessage(mail);
        return ResponseEntity.ok(new MessageResponse("envoie mail se fait avec succé"));
    }
    @GetMapping("/emailannulationmeeting/{id}")
    public ResponseEntity<MessageResponse> Annulationmeetingemail(@PathVariable("id") Long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);
        Mail mail = new Mail();
        mail.setFrom("dminrh848@gmail.com");
        mail.setTo(employee.get().getEmail());
        mail.setSubject(" \n" + " cancelation of meeting ");
        mail.setContent("Dear "+employee.get().getPrenom()+""+employee.get().getNom()+","+"\r\n" +
                "\r\n" +
                "we are sorry the meeting is canceled  \r\n" +
                " thank you \r\n" +
                "Cordially,");
        emailService.sendSimpleMessage(mail);
        return ResponseEntity.ok(new MessageResponse("envoie mail se fait avec succé"));
    }




}
