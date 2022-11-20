package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Fichedepaie;
import com.grh.pfeprv.payloads.request.FichdepaieRequest;
import com.grh.pfeprv.payloads.response.FichedepaieResponse;
import com.grh.pfeprv.payloads.response.MessageResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public interface IFichedepaieservice {
    public List<Fichedepaie> affichagesimple();
    public List<FichedepaieResponse> Affichageficheuser();
    public ResponseEntity<MessageResponse> Ajoutfiche(FichdepaieRequest f);
    public ResponseEntity<MessageResponse> Miseajourfiche(Long id,FichdepaieRequest f);
    public ResponseEntity<MessageResponse> Effacerfiche(Long id);
    public List<FichedepaieResponse> Affichageuserid(Long id);
    public Fichedepaie Detailfiche(Long id);
    //public List<FichedepaieResponse> chercherfiche(String nom,String prenom);
    public String exportfichedepaie(Long id,Long emplid) throws FileNotFoundException, JRException;
    //public ByteArrayInputStream exportfichep(FichdepaieRequest fichdepaieRequest);
    public  List<FichedepaieResponse> chercherficheparjobid(String jobid);



}
