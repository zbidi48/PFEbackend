package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Conge;
import com.grh.pfeprv.payloads.request.CongeRequest;
import com.grh.pfeprv.payloads.response.CongeResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICongeService {
    public List<CongeResponse> afficherconge();
    public ResponseEntity<MessageResponse> ajoutdemandeconge(CongeRequest congeRequest);
    public ResponseEntity<MessageResponse> miseajourconge(Long id,CongeRequest congeRequest);
    public  ResponseEntity<MessageResponse> supprimerconge(Long id);
    public Conge detailconge(Long id);
    public List<CongeResponse> chercherconge(String nom,String prenom);
    public List<CongeResponse> affichercongeparmail(String mail);
    public ResponseEntity<MessageResponse> accordconge(Long id,CongeRequest congeRequest);
}
