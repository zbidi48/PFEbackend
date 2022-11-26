package com.grh.pfeprv.controller;

import com.grh.pfeprv.payloads.request.EvaluationRequest;
import com.grh.pfeprv.payloads.response.MessageResponse;
import com.grh.pfeprv.service.EvalutaionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
@CrossOrigin("*")

public class EevaluationController {

private EvalutaionService evalutaionService;

    public EevaluationController(EvalutaionService evalutaionService) {
        this.evalutaionService = evalutaionService;
    }

    @PostMapping("/add")
       public ResponseEntity<MessageResponse> saveEvaluation(@RequestBody EvaluationRequest evaluationRequest) {
        return ResponseEntity.ok(evalutaionService.addEvaluation(evaluationRequest));


}
    @GetMapping("/totalbien")
    public ResponseEntity<Long> getTotalOfEvaluationBien(){
        return ResponseEntity.ok(evalutaionService.totalBien());
    }
    @GetMapping("/totalassezbien")
    public ResponseEntity<Long> getTotalOfEvaluationAssezBien(){
        return ResponseEntity.ok(evalutaionService.totalAssezBien());
    }
    @GetMapping("/totalpastellement")
    public ResponseEntity<Long> getTotalOfEvaluationPasTellemnt(){
        return ResponseEntity.ok(evalutaionService.totalpastellemnt());
    }
}
