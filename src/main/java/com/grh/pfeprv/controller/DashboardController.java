package com.grh.pfeprv.controller;

import com.grh.pfeprv.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/dashboard")

public class DashboardController {

    DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/nbremp")
    public ResponseEntity<Long> getNbrEmpl(){
        return  ResponseEntity.ok().body(dashboardService.nbEmploye());
    }

    @GetMapping("/nbrcondidat")
    public ResponseEntity<Long> getNbrCondidat(){
        return  ResponseEntity.ok().body(dashboardService.nbCondidat());
    }
}
