package com.grh.pfeprv.payloads.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.net.URL;
import java.sql.Date;

@Data


public class ContratResponse {
    private  Long id;

    private  String type;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date datedebut;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")

    private  String nom;
    private  String prenom;
    private  String post;
    private  String jobid;
    private  String url;
    public ContratResponse()
    {

    }

   public  ContratResponse(Long id,String type,Date datedebut,
                           String nom,String prenom,String post,String jobid, String url)
   {
       this.id=id;
       this.type=type;
       this.datedebut=datedebut;
       this.nom=nom;
       this.prenom=prenom;
       this.post=post;
       this.jobid=jobid;
       this.url=url;
   }
}
