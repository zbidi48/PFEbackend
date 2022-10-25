package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.service.ICondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
