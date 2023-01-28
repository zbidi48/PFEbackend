package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Employee;
import com.grh.pfeprv.domaine.Role;
import com.grh.pfeprv.enums.ERole;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.payloads.request.EmployeeRequest;
import com.grh.pfeprv.payloads.response.EmployeeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.RoleRepository;
import com.grh.pfeprv.repository.UserRepository;
import com.grh.pfeprv.service.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

import org.springframework.security.crypto.password.PasswordEncoder;

import static com.grh.pfeprv.enums.ERole.ROLE_Employee;

@Service
public class EmployeeServiceImpl implements IEmployeService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<EmployeeResponse> AfficherEmployee() {
        List<EmployeeResponse> response = new ArrayList<>();
        employeeRepository.findBySupprIsFalse().forEach(employee -> {
            response.add(new EmployeeResponse(
                    employee.getId(),
                    employee.getNom(),
                    employee.getPrenom(),
                    employee.getPost(),
                    employee.getJobid()));
        });
        return response;
    }


    @Override
    public ResponseEntity<MessageResponse> AjoutEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        Role role = roleRepository.findByName(ERole.ROLE_Employee).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        employee.setNom(employeeRequest.getNom());
        employee.setPrenom(employeeRequest.getPrenom());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPost(employeeRequest.getPost());
        employee.setDepartement(employeeRequest.getDepartement());
        employee.setSalary(employeeRequest.getSalary());
        employee.setCnss(employeeRequest.getCnss());
        employee.setPassword(encoder.encode(employeeRequest.getPassword()));
        employee.setStatus(employeeRequest.getStatus());
        employee.setJobid(employeeRequest.getJobid());
        employee.setSuppr(false);
        employee.setRoles(roles);
        userRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("employee ajouter avec success !"));
    }


    @Override
    public ResponseEntity<MessageResponse> Miseajouremploye(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> emp= employeeRepository.findById(id);
        if(!emp.isPresent())
        {
            throw new NotFoundException("Employee ID: " + id + " not found");
        }
        Employee employee = emp.get();
        employee.setNom(employeeRequest.getNom());
        employee.setPrenom(employeeRequest.getPrenom());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPost(employeeRequest.getPost());
        employee.setDepartement(employeeRequest.getDepartement());
        employee.setSalary(employeeRequest.getSalary());
        employee.setCnss(employeeRequest.getCnss());
        employee.setStatus(employeeRequest.getStatus());
        employee.setJobid(employeeRequest.getJobid());
        employeeRepository.save(employee);

        return ResponseEntity.ok(new MessageResponse(" modification employee  faite  avec succeé"));
    }

    @Override
    public ResponseEntity<MessageResponse> Effaceremplyee(Long id) {
        Optional<Employee> empl =employeeRepository.findById(id);
        if(!empl.isPresent())
        {
            throw new NotFoundException("employee ID: " + id + " not found");

        }
        Employee employee = empl.get();
        employee.setSuppr(true);
        employeeRepository.save(employee);
        return ResponseEntity.ok(new MessageResponse("Employee supprimer avec succeé"));
    }

    @Override
    public Employee DetailEmployee(Long id) {
        Optional<Employee> emp= employeeRepository.findById(id);
        if(!emp.isPresent())
        {
            throw new NotFoundException("Employee Id:"+id+"n existe pas");

        }
        return emp.get();
    }


    @Override
    public List<Employee> recherche(String query) {
        return employeeRepository.findAllByNomAndSupprIsFalseOrPrenomAndSupprIsFalseOrJobidAndSupprIsFalse(query,query,query);
    }
}
