package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.payloads.request.EmployeeRequest;
import com.grh.pfeprv.payloads.response.EmployeeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IEmployeService {
    public List<EmployeeResponse> AfficherEmployee();
    public ResponseEntity<MessageResponse> AjoutEmployee( EmployeeRequest employeeRequest);
    public ResponseEntity<MessageResponse> Miseajouremploye(Long id,EmployeeRequest employeeRequest);
    public  ResponseEntity<MessageResponse> Effaceremplyee(Long id);
    public  Employee DetailEmployee(Long id);
    public  ResponseEntity<List<Employee>> chercheremployee(String jobid);

}
