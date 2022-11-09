package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Entretient;
import com.grh.pfeprv.payloads.request.EntretientRequest;
import com.grh.pfeprv.payloads.response.EntretientResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEntretientService {
    public List<EntretientResponse> Afficherentretient();
    public ResponseEntity<MessageResponse> Ajouterentretient(EntretientRequest entretientRequest);
    public ResponseEntity<MessageResponse> Miseajourentretient(Long id,EntretientRequest entretientRequest);
    public ResponseEntity<MessageResponse> Supprimerentretient(Long id);
    public Entretient Detailentretient(Long id);
    public  List<EntretientResponse> Chercherentretient(String nom,String prenom);
    public List<EntretientResponse> afficherentretientparmail(String email);
    public ResponseEntity<MessageResponse> accordentretient(Long id,String status);


}
