package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Entretient;
import com.grh.pfeprv.payloads.request.EntretientRequest;
import com.grh.pfeprv.payloads.response.EntretientResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntretientService {
    ResponseEntity<MessageResponse> Ajouterentretient(EntretientRequest entretientRequest);
     List<EntretientResponse> Afficherentretient();
     ResponseEntity<MessageResponse> accordentretient(Long id,String status);
     List<EntretientResponse> afficherentretientparmail(String email);
  /*  public List<EntretientResponse> Afficherentretient();

    public ResponseEntity<MessageResponse> Miseajourentretient(Long id,EntretientRequest entretientRequest);
    public ResponseEntity<MessageResponse> Supprimerentretient(Long id);
    public Entretient Detailentretient(Long id);


    public ResponseEntity<MessageResponse> accordentretient(Long id,String status);
    public List<EntretientResponse> chercher(String key);*/


}
