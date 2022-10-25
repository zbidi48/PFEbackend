package com.grh.pfeprv.controller;


import com.grh.pfeprv.payloads.request.LoginRequest;
import com.grh.pfeprv.payloads.request.SignupRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService service;


    @PostMapping("/signin")
    public ResponseEntity<?> signin( @RequestBody LoginRequest loginRequest) {
        return  service.signin(loginRequest);
    }

    @PostMapping("/employe/signup")
    public ResponseEntity<MessageResponse> signupEmp(@RequestBody SignupRequest signupRequest) {
        return  service.signupEmp(signupRequest);
    }
    @PostMapping("/condidat/signup")
    public ResponseEntity<MessageResponse> signupCond(@RequestBody SignupRequest signupRequest) {
        return  service.signupCondidat(signupRequest);
    }
    @PostMapping("/serviceRH/signup")
    public ResponseEntity<MessageResponse> signupRH(@RequestBody SignupRequest signupRequest) {
        return  service.signupRH(signupRequest);
    }


}
