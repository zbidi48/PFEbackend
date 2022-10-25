package com.grh.pfeprv.service;


import com.grh.pfeprv.domaine.Presence;

import com.grh.pfeprv.payloads.request.PresenceRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.payloads.response.PresenceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPresenceService {
    public List<Presence> AffPresence();
    public ResponseEntity<MessageResponse> Ajouprsence(PresenceRequest pr);
    public ResponseEntity<MessageResponse> MAPresence(Long id,PresenceRequest pr);
    public ResponseEntity<MessageResponse> EffPresence(Long id);
    public Presence AffPresencebyid(Long id);
    public List<PresenceResponse> Affpresencebyuser(Long id);
    public List<PresenceResponse> Affpresencebyusermail(String email);
}
