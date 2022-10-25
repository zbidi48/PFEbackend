package com.grh.pfeprv.controller;


import com.grh.pfeprv.domaine.Presence;
import com.grh.pfeprv.payloads.request.PresenceRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.PresenceResponse;
import com.grh.pfeprv.repository.PresenceRepository;
import com.grh.pfeprv.service.IPresenceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/presence")
@CrossOrigin("*")
public class PresenceController {

    IPresenceService iPresenceService;
    private PresenceRepository repository;

    public PresenceController(IPresenceService iPresenceService, PresenceRepository repository) {
        this.iPresenceService = iPresenceService;
        this.repository = repository;
    }

    @GetMapping("/afficherpresence")
    public List<PresenceResponse> AFFPresence()
    {
        List<PresenceResponse> response = new ArrayList<>();
        repository.findAll().forEach(presence -> {
            response.add(new PresenceResponse(
                    presence.getId(),
                    presence.getDate(),
                    presence.getNbreheure(),
                    presence.getUser().getNom(),
                    presence.getUser().getPrenom()));
        });
        return response;
    }
    @PostMapping("/ajouterpresence")
    public  ResponseEntity<MessageResponse> AjoutPresence(@RequestBody PresenceRequest pr)
    {
        return iPresenceService.Ajouprsence(pr);
    }
    @PutMapping("/modifierpresence/{id}")
    public  ResponseEntity<MessageResponse> MajourPresence(@PathVariable(value="id") long id
            ,@RequestBody PresenceRequest pr )
    {
        return iPresenceService.MAPresence(id,pr);
    }
    @DeleteMapping("/supprimerpresence/{id}")
    public  ResponseEntity<MessageResponse> SupprimerPresence(@PathVariable(value="id") long id)
    {
        return iPresenceService.EffPresence(id);
    }
    @GetMapping("/detailpresenceuser/{userid}")
    public  List<PresenceResponse> Afficherpresencebyuser(@PathVariable(value="userid") Long userid)
    {
        return iPresenceService.Affpresencebyuser(userid);
    }

    @GetMapping("/detailpresence/{id}")
    public  Presence  Detailpresence(@PathVariable(value="id") long id)
    {

        return iPresenceService.AffPresencebyid(id);
    }
    @GetMapping("/afficherpresenceparusermail/{email}")
    public  List<PresenceResponse> Affusermail(@PathVariable(value ="email") String email)
    {
        return iPresenceService.Affpresencebyusermail(email);
    }
}


