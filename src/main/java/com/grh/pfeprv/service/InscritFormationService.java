package com.grh.pfeprv.service;


import com.grh.pfeprv.payloads.request.InscritFormationRequest;
import com.grh.pfeprv.payloads.response.InscritFormationResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InscritFormationService {
    List<InscritFormationResponse>  Afficherinscritformation();
     ResponseEntity<MessageResponse> Inscritformation(Long idemployee,Long idformation);
     ResponseEntity<MessageResponse> Supprimerinscrit(Long id);
     ResponseEntity<InscritFormationResponse> Detailleinscritformation(Long id);
     List<InscritFormationResponse> Chercherinscritformationparjobid(String jobid);
     //List<InscritFormationResponse> Chercherinscritformationparnometprenom(String nom, String prenom);
     ResponseEntity<MessageResponse> changersatus(Long id,String status);
     List<InscritFormationResponse> Afficherinscritformationparemployeeid(Long employeeid);



}