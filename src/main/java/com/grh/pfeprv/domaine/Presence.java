package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "presence")
public class Presence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double nbreheure;
    @ManyToOne
    @JoinColumn( name="user_id" )
    @JsonIgnore
    private User user;

    /*
    { id: 1,
        date : 9/4/2022,
        nbreheure: 8,
        user: {Ahmed}
        },
        { id: 2,
        date : 9/4/2022,
        nbreheure: 8,
        user: {Ahmed}
        }
     */


}
