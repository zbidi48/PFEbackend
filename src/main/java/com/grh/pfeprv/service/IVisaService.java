package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Visa;
import com.grh.pfeprv.payloads.request.VisaRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.VisaResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVisaService {
    public List<VisaResponse> Affichervisa();
    public ResponseEntity<MessageResponse> Ajoutervisa(VisaRequest visaRequest);
    public ResponseEntity<MessageResponse> Miseajourvisa(Long id,VisaRequest visaRequest);
    public ResponseEntity<MessageResponse> Supprimervisa(Long id);
    public Visa Detailvisa(Long id);
    public ResponseEntity<MessageResponse> Accordvisa(Long id,String status);
    public List<VisaResponse> affichervisaparmail(String email);
    public List<VisaResponse> Cherchervisa(String jobid);

}
