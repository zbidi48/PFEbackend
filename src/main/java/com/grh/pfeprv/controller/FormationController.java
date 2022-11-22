package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Formation;
import com.grh.pfeprv.payloads.request.FormationRequest;

import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formation")
@CrossOrigin("*")
public class FormationController {
    @Autowired
    IFormationService iFormationService;
    @GetMapping("/listformation")
    public ResponseEntity<List<Formation>> AfficherFormations()
    {
        return iFormationService.AffForm();
    }
    @PostMapping("/ajouterformation")
    public ResponseEntity<MessageResponse> AjouterFormation(@RequestBody FormationRequest frm)
    {
        return  iFormationService.AjouForm(frm);
    }
    @PutMapping("/miseajourformation/{id}")
    public ResponseEntity<MessageResponse> MiseajourFormation(@PathVariable(value="id") Long id,
                                                              @RequestBody FormationRequest fr)
    {
        return iFormationService.MAForm(id,fr);
    }
    @DeleteMapping("/deleteformation/{id}")
    public  ResponseEntity<MessageResponse> EffacerFormation(@PathVariable(value="id") Long id)
    {
        return iFormationService.EffForma(id);
    }
    @GetMapping("/listformation/{typeformation}")
    public  ResponseEntity<List<Formation> > RechercheFormation(@PathVariable(value="typeformation") String typeformation )
    {
        return ResponseEntity.ok(iFormationService.RechercheFormation(typeformation));
    }
    @GetMapping("affformid/{id}")
    public ResponseEntity<Formation> AfficherFormationid(@PathVariable(value="id") Long id)
    {

        return ResponseEntity.ok( iFormationService.AffFormid(id));
    }

}
