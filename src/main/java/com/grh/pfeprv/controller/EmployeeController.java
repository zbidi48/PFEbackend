package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.payloads.request.EmployeeRequest;
import com.grh.pfeprv.payloads.response.EmployeeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;

import com.grh.pfeprv.service.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    IEmployeService iEmployeService;

     @GetMapping("/listemployee")
     public ResponseEntity<List<EmployeeResponse>> AffEmp()
     {
         return  ResponseEntity.ok(iEmployeService.AfficherEmployee());
     }
     @PutMapping("/miseajouemplyee/{id}")
    public ResponseEntity<MessageResponse> MAEmpl(@PathVariable(value = "id") Long id
             ,@RequestBody EmployeeRequest employeeRequest)
     {

         return iEmployeService.Miseajouremploye(id,employeeRequest);
     }
     @PostMapping("/crieremployee")
     public  ResponseEntity<MessageResponse> Crieremployee(@RequestBody EmployeeRequest employeeRequest)
     {
         return iEmployeService.AjoutEmployee(employeeRequest);
     }
     @DeleteMapping("/effaceremployee/{id}")
     public ResponseEntity<MessageResponse> EffEmpl(@PathVariable(value = "id") Long id)
     {
         return iEmployeService.Effaceremplyee(id);
     }
     @GetMapping("/chercheremployee/{jobid}")
     public  ResponseEntity<List<Employee>> ChercherEmpl(@PathVariable(value = "jobid") String jobid)
     {
         return iEmployeService.chercheremployee(jobid);
     }
     @GetMapping("/detailempl/{id}")
    public ResponseEntity<Employee> DetailEmpl(@PathVariable(value = "id") Long id)
     {

         return  ResponseEntity.ok(iEmployeService.DetailEmployee(id));
     }
     @PostMapping("/chercherparnometprenom/{nom}/{prenom}")
     public ResponseEntity<List<Employee>> Chercherparnometprenom(@PathVariable(value = "nom") String nom,
                                                                                  @PathVariable(value = "prenom") String prenom)
     {
         return ResponseEntity.ok(iEmployeService.chercheremployeeparnometprenom(nom,prenom));
     }
     @GetMapping("/rechercheemployee/{query}")
    public ResponseEntity<List<Employee>> Rechercheemploy(@PathVariable(value = "query") String query)
     {
         return ResponseEntity.ok(iEmployeService.recherche(query));
     }
}
