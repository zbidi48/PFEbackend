package com.grh.pfeprv.controller;
import com.grh.pfeprv.domaine.Conge;
import com.grh.pfeprv.payloads.request.CongeRequest;
import com.grh.pfeprv.payloads.response.CongeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.ICongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Conge")
@CrossOrigin("*")
public class CongeController {
    @Autowired
    ICongeService icongeService;
    @GetMapping("/listconge")
    public ResponseEntity<List<CongeResponse>> AfficheConge()
    {
        return ResponseEntity.ok(icongeService.afficherconge());
    }
    @PostMapping("/ajoutedemandeconge")
    public ResponseEntity<MessageResponse> Ajoutdemandeconge(@RequestBody CongeRequest congeRequest)
    {
        return icongeService.ajoutdemandeconge(congeRequest);
    }
   @PutMapping("/miseajourconge/{id}")
   public  ResponseEntity<MessageResponse> Miseajourdemandeconge(@PathVariable(value="id") long id,
                                                                 @RequestBody CongeRequest congeRequest)
   {
       return  icongeService.miseajourconge(id,congeRequest);
   }
   @DeleteMapping("/supprimerconge/{id}")
    public  ResponseEntity<MessageResponse> SupprimerDemandeconge(@PathVariable(value="id") long id)
   {
       return icongeService.supprimerconge(id);
   }
   @RequestMapping("/chercherdemandeconge/{jobid}")
    public  ResponseEntity<List<CongeResponse>> Chercherconge(@PathVariable(value="jobid") String jobid)
   {
       return ResponseEntity.ok(icongeService.chercherconge(jobid));
   }
   @GetMapping("/detailconge/{id}")
    public ResponseEntity<Conge>  Detailconge(@PathVariable(value="id") long id){

        return ResponseEntity.ok( icongeService.detailconge(id));
   }
   @GetMapping("/affichercongeparmail/{mail}")
    public  ResponseEntity<List<CongeResponse>> Afficherdemandecongeparmail(@PathVariable(value="mail") String mail)
   {
       return ResponseEntity.ok(icongeService.affichercongeparmail(mail));
   }
    @PutMapping("/statusconge/{id}")
    public ResponseEntity<MessageResponse> AccordConge(@PathVariable(value="id") Long id,
                                                       @RequestBody CongeRequest congeRequest)
    {
        return  icongeService.accordconge(id,congeRequest);
    }
}
