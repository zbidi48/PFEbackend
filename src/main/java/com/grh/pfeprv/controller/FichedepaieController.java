package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Fichedepaie;
import com.grh.pfeprv.payloads.request.FichdepaieRequest;
import com.grh.pfeprv.payloads.response.FichedepaieResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IFichedepaieservice;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/fichedepaie")
public class FichedepaieController {
    @Autowired
    IFichedepaieservice iFichedepaieservice;
    @GetMapping("/affichagefichesimp")
    public ResponseEntity<List<Fichedepaie>> Afffichsimp()
    {

        return ResponseEntity.ok(iFichedepaieservice.affichagesimple());
    }
    @GetMapping("/detailfiche/{id}")
    public ResponseEntity< Fichedepaie> Detailfiche(@PathVariable(value="id") long id)
    {

        return ResponseEntity.ok(iFichedepaieservice.Detailfiche(id));
    }
    @RequestMapping(value = "/detailficheuserid/{id}", method = RequestMethod.GET)
    public ResponseEntity< List<FichedepaieResponse> > Affficheuserid(@PathVariable(value="id") long id)
    {
        return ResponseEntity.ok(iFichedepaieservice.Affichageuserid(id));
    }
    @GetMapping("/affichageficheuser")
    public ResponseEntity<List<FichedepaieResponse>>  Afffchuser()
    {

        return ResponseEntity.ok(iFichedepaieservice.Affichageficheuser());
    }
    @GetMapping("/chercherfichedepaie/{jobid}")
    public  ResponseEntity<List<FichedepaieResponse>> chercherfichedepaie(@PathVariable(value="jobid") String jobid)
    {
        return ResponseEntity.ok(iFichedepaieservice.chercherficheparjobid(jobid));
    }
    @PostMapping("/ajouterfiche")
    public ResponseEntity<MessageResponse> Ajouterfiche(@RequestBody FichdepaieRequest fichdepaieRequest)
    {
        return  iFichedepaieservice.Ajoutfiche(fichdepaieRequest);
    }
    @PutMapping("/miseajourfiche/{id}") //probleme resolu
    public  ResponseEntity<MessageResponse> MAfiche(@PathVariable(value="id") long id,
                                                    @RequestBody FichdepaieRequest fichdepaieRequest)
    {
        return  iFichedepaieservice.Miseajourfiche(id,fichdepaieRequest);
    }
    @DeleteMapping("/supprimerfiche/{id}")
    public ResponseEntity<MessageResponse> Efffiche(@PathVariable(value="id") long id)
    {
        return  iFichedepaieservice.Effacerfiche(id);
    }

    @PostMapping ("/chercherfiche/{nom}/{prenom}")
    public  ResponseEntity<List<FichedepaieResponse>> Chercherfichedepaie(@PathVariable(value="nom") String nom,
                                                    @PathVariable(value="prenom")String prenom)
    {
        return  ResponseEntity.ok(iFichedepaieservice.Chercherparnometprenom(nom,prenom));
    }


    @PostMapping("/exporterpdf/{id}/{emplid}")
    public  ResponseEntity<MessageResponse> exporterpdf(@PathVariable(value="id") Long id,
                                                        @PathVariable(value="emplid") Long emplid) throws JRException, FileNotFoundException {
        return iFichedepaieservice.exportfichedepaie(id,emplid);
    }



}
