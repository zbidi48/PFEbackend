package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.enums.ERole;
import com.grh.pfeprv.repository.FormationRepository;
import com.grh.pfeprv.repository.UserRepository;
import com.grh.pfeprv.repository.VisaRepository;
import com.grh.pfeprv.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    UserRepository userRepository;
    @Autowired
   FormationRepository formationRepository;
    @Autowired
    VisaRepository visaRepository;
    public Long nbEmploye() {
        return userRepository.nbEmp();
    }

    @Override
    public Long nbCondidat() {
        return userRepository.nbCondidat();
    }

    @Override
    public Long nbformation() {
        return formationRepository.nbrformation();
    }

    @Override
    public Long nbvisa() {
        return visaRepository.nbrvisa();
    }
}
