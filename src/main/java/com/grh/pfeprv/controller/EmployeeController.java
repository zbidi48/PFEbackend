package com.grh.pfeprv.controller;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.payloads.request.EmployeeRequest;
import com.grh.pfeprv.payloads.response.EmployeeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;

import com.grh.pfeprv.service.IEmployeService;
import com.grh.pfeprv.service.IFichedepaieservice;
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
     public List<EmployeeResponse> AffEmp()
     {
         return  iEmployeService.AfficherEmployee();
     }
     @PutMapping("/miseajouemplyee/{id}")
    public ResponseEntity<MessageResponse> MAEmpl(@PathVariable(value = "id") Long id
             ,@RequestBody EmployeeRequest employeeRequest)
     {

         return iEmployeService.Miseajouremploye(id,employeeRequest);
     }
     @DeleteMapping("/effaceremployee/{id}")
     public ResponseEntity<MessageResponse> EffEmpl(@PathVariable(value = "id") Long id)
     {
         return iEmployeService.Effaceremplyee(id);
     }
     @GetMapping("/chercheremployee/{jobid}")
     public  Employee ChercherEmpl(@PathVariable(value = "jobid") String jobid)
     {
         return iEmployeService.chercheremployee(jobid);
     }
     @GetMapping("/detailempl/{id}")
    public Employee DetailEmpl(@PathVariable(value = "id") Long id)
     {
         return  iEmployeService.DetailEmployee(id);
     }
}
