package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Offreemploie;
import com.grh.pfeprv.payloads.request.OffreemploieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOffreemploieService {
    public List<Offreemploie> Afficheroffres();
    public ResponseEntity<MessageResponse> Ajouteroffre(OffreemploieRequest offreemploieRequest);
    public  ResponseEntity<MessageResponse> Miseajouroffre(Long id,OffreemploieRequest offreemploieRequest);
    public  ResponseEntity<MessageResponse> Supprimeroffre(Long id);
    public  Offreemploie Detailoffre(Long id);
    public List<Offreemploie> rechercheoffer(String titredoffre);

}
