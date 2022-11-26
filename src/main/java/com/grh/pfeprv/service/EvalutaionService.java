package com.grh.pfeprv.service;

import com.grh.pfeprv.payloads.request.EvaluationRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;

public interface EvalutaionService {

    MessageResponse addEvaluation(EvaluationRequest evaluationRequest);
    Long totalBien();
    Long totalAssezBien();
    Long totalpastellemnt();
}
