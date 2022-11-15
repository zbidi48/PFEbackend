package com.grh.pfeprv;

import com.grh.pfeprv.domaine.*;
import com.grh.pfeprv.enums.ERole;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.repository.EmployeeRepository;
import com.grh.pfeprv.repository.RoleRepository;
import com.grh.pfeprv.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


@SpringBootApplication
public class PfEprvApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfEprvApplication.class, args);
    }

CommandLineRunner start(RoleRepository roleRepository,
                        UserRepository userRepository,
                         PasswordEncoder encoder,
                        EmployeeRepository employeeRepository,
                        CondidatRepository condidatRepository) {
       return args -> {
           if(roleRepository.findAll().isEmpty()){
               Stream.of(ERole.ROLE_Condidat,  ERole.ROLE_Employee, ERole.ROLE_serviceRH).forEach(r -> {
                   Role role = new Role();
                   role.setName(r);
                   roleRepository.save(role);
               });
           }


           Set<Role> roles = new HashSet<>();
           roles.add(roleRepository.findByName(ERole.ROLE_serviceRH).get());

           //User user = new User();
           ServiceRH user = new ServiceRH();
           user.setEmail("ahmed.zbidi1@esprit.tn");
           user.setPassword(encoder.encode("1759848"));
           user.setNom("ahmed");
           user.setPrenom("zbidi");
           user.setPost("ingenieure");
           user.setJobid("rh147");
           user.setDepartement("departementRH");
           user.setRoles(roles);
           userRepository.save(user);


           Set<Role> roles1 = new HashSet<>();
           roles1.add(roleRepository.findByName(ERole.ROLE_Employee).get());
           //User user1 = new User();
           Employee user1=new Employee();
           user1.setEmail("jamilahalouas1955@gmail.com");
           user1.setPassword(encoder.encode("123123"));
           user1.setNom("jamila");
           user1.setPrenom("halouas");
           user1.setPost("techne");
           user1.setSalary("1800$");
           user1.setDepartement("informatique");
           user1.setCnss("cnss");
           user1.setJobid("empl478");
           user1.setStatus("ok");

           user1.setRoles(roles1);
           //employeeRepository.save(user1);

           /*
           Set<Role> roles = new HashSet<>();
           roles.add(roleRepository.findByName(ERole.ROLE_Condidat).get());

           //User user = new User();
           Condidats condidats=new Condidats();
           condidats.setEmail("mohamedsalah@gmail.com");
           condidats.setPassword(encoder.encode("123456"));
           condidats.setNom("mohamed");
           condidats.setPrenom("salah");
           condidats.setPost("technesup");
           condidats.setNationality("tunisien");
           condidats.setAdresse("mahdia");
           condidats.setNiveauEtud("bac+3");
           condidats.setExperience("0 ans");
           condidats.setTitreDiplome("lisence");



           condidats.setRoles(roles);
           condidatRepository.save(condidats);
            */



       };
   }






















   }

