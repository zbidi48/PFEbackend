package com.grh.pfeprv.controller;


import com.grh.pfeprv.domaine.Notedefraie;
import com.grh.pfeprv.payloads.request.NotedefraieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.NotedefraieResponse;
import com.grh.pfeprv.service.INotedefraieService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<NotedefraieResponse> Affichernotedefraie()
    {
        return iNotedefraieService.Affichernotedefraie();
    }
    @PostMapping("/ajouternotedefraie")
    public ResponseEntity<MessageResponse> Ajoutnotedefraie(@RequestBody NotedefraieRequest notedefraieRequest)
    {
        return  iNotedefraieService.Ajoutnotedefraie(notedefraieRequest);
    }
    /*
    @PutMapping("/miseajournotedefraie/{id}")
    public ResponseEntity<MessageResponse> Miseajournotedefraie(@PathVariable(value="id") Long id,
                                                                @RequestBody NotedefraieRequest notedefraieRequest)
    {
        return iNotedefraieService.Miseajournotedefraie(id, notedefraieRequest);
    }
     */
    @DeleteMapping("/supprimernotedefraie/{id}")
    ResponseEntity<MessageResponse> Supprimernotedefraie(@PathVariable(value="id") Long id)
    {
        return iNotedefraieService.Supprimernotedefraie(id);
    }
    @GetMapping("/cherchernotedefraie/{jobid}")
    public List<NotedefraieResponse> cherchernotedefraie(@PathVariable(value="jobid") String jobid)
    {
        return iNotedefraieService.Cherchernotedefraie(jobid);
    }
    @RequestMapping("/affichernotedefraieparmail/{email}")
    public List<NotedefraieResponse> Affichernotedefraieparmail(@PathVariable(value="email") String email)
    {
        return iNotedefraieService.Affichernotedefraieparmail(email);
    }
    @GetMapping("/detaillnotedefraie/{id}")
    public Notedefraie Detaillnotedefraie(@PathVariable(value="id") Long id)
    {
        return iNotedefraieService.Affichernotedefraieparid(id);
    }

}
