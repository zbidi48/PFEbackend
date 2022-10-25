package com.grh.pfeprv.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data


public class ContratResponse {
    private  Long id;
    private  String code;
    private  String libelle;
    private Date datedebut;
    private Date datefin;
    private  String nom;
    private  String prenom;
    private  String post;
    private  String jobid;

   public  ContratResponse(Long id,String code,String libelle,Date datedebut,Date datefin,String nom,String prenom,String post,String jobid)
   {
       this.id=id;
       this.code=code;
       this.libelle=libelle;
       this.datedebut=datedebut;
       this.datefin=datefin;
       this.nom=nom;
       this.prenom=prenom;
       this.post=post;
       this.jobid=jobid;
   }
}
