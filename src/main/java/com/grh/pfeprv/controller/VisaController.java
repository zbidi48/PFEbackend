package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Visa;
import com.grh.pfeprv.payloads.request.VisaRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.VisaResponse;

import com.grh.pfeprv.service.IVisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visa")
@CrossOrigin("*")
public class VisaController {
@Autowired
IVisaService iVisaService;
@GetMapping("/listvisas")
public ResponseEntity<List<VisaResponse>> Affichervisas()
{

    return  ResponseEntity.ok(  iVisaService.Affichervisa());

}
@PostMapping("/ajoutervisa")
public ResponseEntity<MessageResponse> Ajoutervisa(@RequestBody VisaRequest visaRequest)
{
    return iVisaService.Ajoutervisa(visaRequest);
}
@PutMapping("/miseajourvisa/{id}")
public ResponseEntity<MessageResponse> Miseajourvisa(@PathVariable(value="id") Long id,
                                                     @RequestBody
                                                     VisaRequest visaRequest)
{
    return iVisaService.Miseajourvisa(id,visaRequest);
}
@DeleteMapping("/supprimervisa/{id}")
public  ResponseEntity<MessageResponse> Supprimervisa(@PathVariable(value="id") Long id)
{
    return iVisaService.Supprimervisa(id);
}
@GetMapping("/detailvisa/{id}")
public ResponseEntity<Visa> Detaillvisa(@PathVariable(value="id") Long id)
{

    return ResponseEntity.ok(iVisaService.Detailvisa(id));
}
@GetMapping("/affichervisaemployee/{email}")
public ResponseEntity<List<VisaResponse> > Affichervisaparmail(@PathVariable(value="email") String email)
{
    return ResponseEntity.ok(iVisaService.affichervisaparmail(email));
}
@PutMapping("/accordvisa/{id}/{status}")
public ResponseEntity<MessageResponse> Accordvisa(@PathVariable(value="id") Long id,
                                                  @PathVariable(value="status") String status)
{
    return iVisaService.Accordvisa(id,status);
}
@GetMapping("/cherchervisa/{jobid}")
public ResponseEntity<List<VisaResponse>> cherchervisa(@PathVariable(value="jobid") String jobid)
{
    return ResponseEntity.ok(iVisaService.Cherchervisa(jobid));
}
@PostMapping("/cherchervisaparnometprenom/{nom}/{prenom}")
public ResponseEntity<List<VisaResponse>> cherchervisaparnometprenom(@PathVariable(value="nom") String nom
,@PathVariable(value="prenom") String prenom)
{
    return ResponseEntity.ok(iVisaService.Cherchervisaparnometpremon(nom,prenom));
}
}
