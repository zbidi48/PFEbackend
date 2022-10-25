package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.Condidats;
import com.grh.pfeprv.repository.CondidatRepository;
import com.grh.pfeprv.service.ICondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CondidatServiceImpl implements ICondidatService {

@Autowired
CondidatRepository condidatRepository;
    @Override
    public List<Condidats> Affichercondidat() {
        return condidatRepository.findAll();
    }
}
