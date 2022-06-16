package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.model.BaseResponse;
import com.imedia.service.mbtransaction.MBTransactionService;
import com.imedia.service.mbtransaction.model.GetMBTransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/")
@Log4j2
public class MBTransactionController {
    static final Gson gson = new Gson();
    private final MBTransactionService mbTransactionService;
    @PostMapping("/listMBTransaction")
    public ResponseEntity<?> getMBTransaction(@Valid @RequestBody GetMBTransactionRequest request){
        try {
            log.info("========GET LIST PROVIDER========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = mbTransactionService.getListMBTransaction(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= LIST PROVIDER EXCEPTION ========" + gson.toJson(request), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }

    }
}
