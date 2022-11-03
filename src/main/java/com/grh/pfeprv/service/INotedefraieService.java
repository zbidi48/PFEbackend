package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Notedefraie;
import com.grh.pfeprv.payloads.request.NotedefraieRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.NotedefraieResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface INotedefraieService {
    public List<NotedefraieResponse> Affichernotedefraie();
    public ResponseEntity<MessageResponse> Ajoutnotedefraie(NotedefraieRequest notedefraieRequest);
    //public ResponseEntity<MessageResponse> Miseajournotedefraie(Long id,NotedefraieRequest notedefraieRequest);
    public ResponseEntity<MessageResponse> Supprimernotedefraie(Long id);
    public List<NotedefraieResponse> Cherchernotedefraie(String jobid);
    public Notedefraie Affichernotedefraieparid(Long id);
    public List<NotedefraieResponse> Affichernotedefraieparmail(String mail);
    //public ResponseEntity<MessageResponse> Statusnotedefraie(Long id,NotedefraieRequest notedefraieRequest);
}
