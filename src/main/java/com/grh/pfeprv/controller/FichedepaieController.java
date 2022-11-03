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
    public List<Fichedepaie> Afffichsimp()
    {
        return iFichedepaieservice.affichagesimple();
    }
    @GetMapping("/detailfiche/{id}")
    public  Fichedepaie Detailfiche(@PathVariable(value="id") long id)
    {
        return iFichedepaieservice.Detailfiche(id);
    }
    @RequestMapping(value = "/detailficheuserid/{id}", method = RequestMethod.GET)
    public  List<FichedepaieResponse> Affficheuserid(@PathVariable(value="id") long id)
    {
        return iFichedepaieservice.Affichageuserid(id);
    }
    @GetMapping("/affichageficheuser")
    public  List<FichedepaieResponse> Afffchuser()
    {
        return iFichedepaieservice.Affichageficheuser();
    }
    @GetMapping("/chercherfichedepaie/{jobid}")
    public  List<FichedepaieResponse> chercherfichedepaie(@PathVariable(value="jobid") String jobid)
    {
        return iFichedepaieservice.chercherficheparjobid(jobid);
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
    /*
    @GetMapping("/chercherfiche/{nom}/{prenom}")
    public  List<FichedepaieResponse> Chercherfiche(@PathVariable(value="nom") String nom,
                                                    @PathVariable(value="prenom")String prenom)
    {
        return  iFichedepaieservice.chercherfiche(nom,prenom);
    }
     */
    /*
    @GetMapping("/exporterpdf/{id}")
    public  String exporterpdf(@PathVariable(value="id") long id) throws JRException, FileNotFoundException {
        return iFichedepaieservice.exportfichedepaie(id);
    }
     */


}
