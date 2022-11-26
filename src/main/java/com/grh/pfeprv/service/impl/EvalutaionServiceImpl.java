package com.grh.pfeprv.service.impl;

import com.grh.pfeprv.domaine.EvaluationFormation;
import com.grh.pfeprv.domaine.InscritFormation;
import com.grh.pfeprv.payloads.request.EvaluationRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.repository.EvaluationFormationRepository;
import com.grh.pfeprv.repository.InscritFormationRepository;
import com.grh.pfeprv.service.EvalutaionService;
import org.springframework.stereotype.Service;

@Service
public class EvalutaionServiceImpl implements EvalutaionService {
    private EvaluationFormationRepository evaluationFormationRepository;
    private InscritFormationRepository inscritFormationRepository;

    public EvalutaionServiceImpl(EvaluationFormationRepository evaluationFormationRepository, InscritFormationRepository inscritFormationRepository) {
        this.evaluationFormationRepository = evaluationFormationRepository;
        this.inscritFormationRepository = inscritFormationRepository;
    }

    @Override
    public MessageResponse addEvaluation(EvaluationRequest evaluationRequest) {
        InscritFormation inscritFormation = inscritFormationRepository.findById(evaluationRequest.getIdInscrit()).get();
        EvaluationFormation evaluationFormation = new EvaluationFormation();
        evaluationFormation.setFormation(inscritFormation.getFormation());
        evaluationFormation.setAvis(evaluationRequest.getAvis());
        evaluationFormationRepository.save(evaluationFormation);
        return  new MessageResponse("Saved !");
    }

    @Override
    public Long totalBien() {
        return evaluationFormationRepository.countAllByAvis("BIEN");
    }

    @Override
    public Long totalAssezBien() {
        return evaluationFormationRepository.countAllByAvis("ASSEZBIEN");
    }

    @Override
    public Long totalpastellemnt() {
        return evaluationFormationRepository.countAllByAvis("PASTELLEMENT");
    }
}
