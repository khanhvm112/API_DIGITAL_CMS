package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.model.BaseResponse;
import com.imedia.service.parservice.ParServiceService;
import com.imedia.service.parservice.model.CreateParServiceRequest;
import com.imedia.service.parservice.model.GetParServiceRequest;
import com.imedia.service.parservice.model.GetParServiceStatus;
import com.imedia.service.parservice.model.UpdateParServiceRequest;
import com.imedia.service.provider.model.InactiveProviderRequest;
import com.imedia.service.provider.model.UpdateProviderRequest;
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
public class ParServiceController {
    static final Gson gson = new Gson();
    public final ParServiceService parServiceService;
    @PostMapping("/listParService")
    public ResponseEntity<?> getListService(@Valid @RequestBody GetParServiceRequest request){
        try {
            log.info("======== GET LIST PARSERVICE ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = parServiceService.getListParService(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= LIST PARSERVICE EXCEPTION ========" + gson.toJson(request), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/createParService")
    public ResponseEntity<?> createService(@Valid @RequestBody CreateParServiceRequest request){
        try {
            log.info("======== CREATE PARSERVICE ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = parServiceService.createParService(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= CREATE PARSERVICE EXCEPTION ========" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/updateParParent")
    public ResponseEntity<?> editParService(@Valid @RequestBody UpdateParServiceRequest request){
        try {
            log.info("======== UPDATE PARSERVICE ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = parServiceService.updateParParent(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= SET STATUS PARSERVICE EXCEPTION ========" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/setStatusParService")
    public ResponseEntity<?> setStatusParService (@Valid @RequestBody GetParServiceStatus request){
        try {
            log.info("======== SET STATUS PARSERVICE ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = parServiceService.setStatusParService(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= SET STATUS PARSERVICE EXCEPTION ========" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }
}
