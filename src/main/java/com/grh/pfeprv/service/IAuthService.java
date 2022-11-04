package com.grh.pfeprv.service;


import com.grh.pfeprv.payloads.request.LoginRequest;
import com.grh.pfeprv.payloads.request.SignupCandidatRequest;
import com.grh.pfeprv.payloads.request.SignupRequest;
import com.grh.pfeprv.payloads.response.JwtResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface IAuthService {
    ResponseEntity<JwtResponse> signin(LoginRequest request);
   ResponseEntity<MessageResponse> signupEmp(SignupRequest request);
   ResponseEntity<MessageResponse> signupRH(SignupRequest request);
   ResponseEntity<MessageResponse> signupCondidat(SignupCandidatRequest request );

}

