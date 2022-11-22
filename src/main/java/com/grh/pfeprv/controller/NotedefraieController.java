package com.grh.pfeprv.controller;


import com.grh.pfeprv.domaine.Notedefraie;
import com.grh.pfeprv.payloads.request.NotedefraieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.NotedefraieResponse;
import com.grh.pfeprv.service.INotedefraieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notedefraie")
@CrossOrigin("*")
public class NotedefraieController  {
    @Autowired
    INotedefraieService iNotedefraieService;
    @GetMapping("/listnotedefraie")
    public ResponseEntity< List<NotedefraieResponse>> Affichernotedefraie()
    {
        return ResponseEntity.ok( iNotedefraieService.Affichernotedefraie());
    }
    @PostMapping("/ajouternotedefraie")
    public ResponseEntity<MessageResponse> Ajoutnotedefraie(@RequestBody NotedefraieRequest notedefraieRequest)
    {
        return  iNotedefraieService.Ajoutnotedefraie(notedefraieRequest);
    }

    @PutMapping("/miseajournotedefraie/{id}")
    public ResponseEntity<MessageResponse> Miseajournotedefraie(@PathVariable(value="id") Long id,
                                                                @RequestBody NotedefraieRequest notedefraieRequest)
    {
        return iNotedefraieService.Miseajournotedefraie(id, notedefraieRequest);
    }

    @DeleteMapping("/supprimernotedefraie/{id}")
      public ResponseEntity<MessageResponse> Supprimernotedefraie(@PathVariable(value="id") Long id)
    {
        return iNotedefraieService.Supprimernotedefraie(id);
    }
    @GetMapping("/cherchernotedefraie/{jobid}")
    public ResponseEntity< List<NotedefraieResponse> > cherchernotedefraie(@PathVariable(value="jobid") String jobid)
    {
        return ResponseEntity.ok(iNotedefraieService.Cherchernotedefraie(jobid));
    }
    @RequestMapping("/affichernotedefraieparmail/{email}")
    public ResponseEntity<List<NotedefraieResponse>> Affichernotedefraieparmail(@PathVariable(value="email") String email)
    {
        return ResponseEntity.ok(iNotedefraieService.Affichernotedefraieparmail(email));
    }
    @GetMapping("/detaillnotedefraie/{id}")
    public ResponseEntity<Notedefraie> Detaillnotedefraie(@PathVariable(value="id") Long id)
    {
        return ResponseEntity.ok(iNotedefraieService.Affichernotedefraieparid(id));
    }

}
