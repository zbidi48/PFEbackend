package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.OffreemploieCondidat;
import com.grh.pfeprv.payloads.request.OffrecondidatRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.OffrecondidatResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOffeCondidatService {
    public List<OffrecondidatResponse> Afficherinscriptionoffre();
    public ResponseEntity<MessageResponse> postuleroffre(Long idoffre,Long idcondidat);
    //public  ResponseEntity<MessageResponse> miseajourinscoffre(Long id,OffrecondidatRequest offrecondidatRequest);

    public  OffrecondidatResponse Afficherinscripparid(Long id);
    public List<OffrecondidatResponse> Chercherinscriptionoffre(String type);
    public List<OffrecondidatResponse> Afficherinscriptionoffreparmail(String mail);
    //public  List<OffrecondidatResponse> Affichercondidatentretient(String status);
    public ResponseEntity<MessageResponse> Statuspostule(Long id, String status);

    public List<OffrecondidatResponse> chercher(String query);

}
