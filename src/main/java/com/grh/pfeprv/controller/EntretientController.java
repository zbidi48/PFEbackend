package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Entretient;
import com.grh.pfeprv.payloads.request.EntretientRequest;
import com.grh.pfeprv.payloads.response.EntretientResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IEntretientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/entretient")
public class EntretientController {
    @Autowired
    IEntretientService iEntretientService;
    @GetMapping("/afficherentretient")
    public ResponseEntity<List<EntretientResponse> > Affichertoutentret()
    {
        return ResponseEntity.ok(iEntretientService.Afficherentretient());
    }
    @PostMapping("/ajouterentretient")
    public ResponseEntity<MessageResponse> Ajouterentret(@RequestBody EntretientRequest request)
    {
        return iEntretientService.Ajouterentretient(request);
    }
    @PutMapping ("/statusentretient/{id}/{status}")
    public  ResponseEntity<MessageResponse> Accordentret(@PathVariable(value="id") Long id,
                                                         @PathVariable(value="status") String status)
    {
        return iEntretientService.accordentretient(id,status);
    }
    @GetMapping("/afficherentreteintparmail/{email}")
    public List<EntretientResponse> Afficherentretparmail(@PathVariable(value="email") String email)
    {
        return iEntretientService.afficherentretientparmail(email);
    }
    @GetMapping("/chercherentretient/{key}")
    public ResponseEntity<List<EntretientResponse>> Rechercherentretient(@PathVariable(value="key") String key)
    {
        return new ResponseEntity(iEntretientService.chercher(key),HttpStatus.ACCEPTED);
    }
    @PutMapping("/miseajourentrtient/{id}")
    public ResponseEntity<MessageResponse> Miseajouentret(@PathVariable(value="id") Long id,
                                                          @RequestBody EntretientRequest request)
    {
        return  iEntretientService.Miseajourentretient(id, request);
    }
    @GetMapping("/detailentretient/{id}")
    public ResponseEntity<Entretient> Detailentret(@PathVariable(value="id") Long id)
    {

        return  ResponseEntity.ok( iEntretientService.Detailentretient(id));
    }

}
