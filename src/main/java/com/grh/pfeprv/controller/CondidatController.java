package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.service.ICondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/condidats")
@CrossOrigin("*")
public class CondidatController {
    @Autowired
    ICondidatService iCondidatService;
    @GetMapping("/affichercondidats")
    public ResponseEntity<List<Condidats> > Affichercondidat()
    {

        return ResponseEntity.ok( iCondidatService.Affichercondidat());
    }
    @GetMapping("/detaillecandidats/{id}")
    public ResponseEntity<Condidats> detaillecandidat(@PathVariable(value="id") Long id)
    {
        return ResponseEntity.ok( iCondidatService.detaillecondidats(id));
    }
    @PostMapping("/cherchercandidat/{nom}/{prenom}")
    public ResponseEntity<List<Condidats>>  cherchercandidats(@PathVariable(value="nom") String nom
            ,@PathVariable(value="prenom") String prenom)
    {
        return ResponseEntity.ok(iCondidatService.cherchercandidat(nom,prenom));
    }
    @GetMapping("/cherchercandidatparcin/{cin}")
    public ResponseEntity<List<Condidats>> cherchercondidatparcin(@PathVariable(value="cin") String cin)
    {
        return new  ResponseEntity(iCondidatService.cherchecondidatparCIN(cin),HttpStatus.ACCEPTED);
    }
}
