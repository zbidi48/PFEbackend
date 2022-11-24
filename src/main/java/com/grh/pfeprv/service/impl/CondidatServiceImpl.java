package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.exception.NotFoundException;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.service.ICondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondidatServiceImpl implements ICondidatService {

@Autowired
CondidatRepository condidatRepository;
    @Override
    public List<Condidats> Affichercondidat() {
        return condidatRepository.findBySupprIsFalse();
    }

    @Override
    public Condidats detaillecondidats(Long id) {
        Optional<Condidats> condidats = condidatRepository.findById(id);
        if(!condidats.isPresent())
        {
            throw new NotFoundException("candidat ID: " + id + " not found");
        }
        return condidats.get();
    }

    @Override
    public List<Condidats> cherchercandidat(String nom, String prenom) {
        return condidatRepository.findAllByNomAndPrenomAndSupprIsFalse(nom,prenom);
    }

    @Override
    public List<Condidats> cherchecondidatparCIN(String cin) {
        return condidatRepository.findAllByCinAndSupprIsFalse(cin);
    }
}
