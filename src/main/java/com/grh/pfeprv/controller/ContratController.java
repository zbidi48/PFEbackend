package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Contrat;
import com.grh.pfeprv.payloads.request.ContratRequest;

import com.grh.pfeprv.payloads.response.ContratResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IContratService;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/contrat")
@CrossOrigin("*")
public class ContratController {
   @Autowired
   IContratService iContratService;

    @GetMapping("/listcontrat")
   public List<ContratResponse> AfficheContrat()
    {
        return iContratService.affichercontart();
    }
    @GetMapping("/affichercontrat")
    public  List<Contrat> Affcontrat()
    {
        return iContratService.Afiichagecontratsimple();
    }
    @PostMapping("/ajoutercontrat")
    public ResponseEntity<MessageResponse> AjouterContrat(@RequestBody ContratRequest contratRequest)
    {
        return  iContratService.Ajoucontrat(contratRequest);
    }
    @PutMapping("/miseajourcontrat/{id}")
    public ResponseEntity<MessageResponse> MiseajourContrat(@PathVariable(value="id") Long id,
                                                            @RequestBody ContratRequest contratRequest)
    {
        return iContratService.MAcontrat(id, contratRequest);
    }
    @DeleteMapping("/supprimercontrat/{id}")
    public  ResponseEntity<MessageResponse> SupprimerContrat(@PathVariable(value="id") Long id)

    {
       return iContratService.Effcontrat(id);
    }
    @GetMapping("/cherchercontrat/{code}")
    public ResponseEntity<List<ContratResponse>> cherchercontratparcode(@PathVariable(value ="code") String code)
    {
        return ResponseEntity.ok(iContratService.Cherchercontrat(code));
    }
    @GetMapping("/cherchercontratparjobid/{jobid}")
    public ResponseEntity<List<Contrat>> cherchercontratparjobid(@PathVariable(value ="jobid") String jobid)
    {
        return ResponseEntity.ok(iContratService.recherchecontratparjobid(jobid));
    }
    @GetMapping ("/detaillcontrat/{id}")
    public  ResponseEntity<Contrat> DetaitContrat(@PathVariable(value="id") Long id)
    {

        return ResponseEntity.ok(iContratService.Affcontratid(id));
    }
    @PostMapping ("/exportcontratpdf/{id}/{emplid}")
    public ResponseEntity<MessageResponse> exportcontratpdf(@PathVariable(value="id") Long id,
                                                            @PathVariable(value="emplid") Long emplid)
            throws JRException, FileNotFoundException, MalformedURLException, URISyntaxException {
        return iContratService.exportcontratpdf(id,emplid);
    }
    @GetMapping("/affichercontratparemployeeid/{emplid}")
    public ResponseEntity<List<ContratResponse>> afficherparemployeeid(  @PathVariable(value="emplid") Long emplid)
    {
        return iContratService.Affichercontratparemplid(emplid);
    }
}
