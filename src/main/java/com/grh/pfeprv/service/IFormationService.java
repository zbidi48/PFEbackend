package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Formation;
import com.grh.pfeprv.payloads.request.FormationRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFormationService {
    public ResponseEntity<List<Formation>> AffForm();
    public ResponseEntity<MessageResponse> AjouForm(FormationRequest fr);
    public ResponseEntity<MessageResponse> MAForm(Long id,FormationRequest fr);
    public ResponseEntity<MessageResponse> EffForma(Long id);
    public  List<Formation> RechercheFormation(String nomformation);
    public Formation AffFormid(Long id);



}
