package com.grh.pfeprv.service;

import com.grh.pfeprv.domaine.Condidats;

import java.util.List;

public interface ICondidatService {
    List<Condidats> Affichercondidat();
    Condidats detaillecondidats(Long id);
    List<Condidats> cherchercandidat(String nom,String prenom);
}
