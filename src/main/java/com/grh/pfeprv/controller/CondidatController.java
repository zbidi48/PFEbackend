package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.service.ICondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/condidats")
@CrossOrigin("*")
public class CondidatController {
    @Autowired
    ICondidatService iCondidatService;
    @GetMapping("/affichercondidats")
    public List<Condidats> Affichercondidat()
    {
        return iCondidatService.Affichercondidat();
    }
    @GetMapping("/detaillecandidats/{id}")
    public Condidats detaillecandidat(@PathVariable(value="id") Long id)
    {
        return iCondidatService.detaillecondidats(id);
    }
}
