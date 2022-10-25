package com.grh.pfeprv.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Type",  discriminatorType=DiscriminatorType.STRING)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String prenom;
    private  String post;
    private String email;

    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();




    @OneToMany(targetEntity=Presence.class,mappedBy="user")
    @JsonIgnore
    private  List<Presence> presences = new ArrayList<>();



  /*
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "contrat_id")
    private  Contrat contrat;
   */





    /*
    @OneToMany(targetEntity =Fichedepaie.class,mappedBy ="user")
    private  List<Fichedepaie> fichedepaies = new ArrayList<>();
     */

}
