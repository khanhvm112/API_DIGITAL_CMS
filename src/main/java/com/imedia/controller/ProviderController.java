package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.model.BaseResponse;
import com.imedia.service.provider.ProviderService;
import com.imedia.service.provider.ProvinceService;
import com.imedia.service.provider.model.CreateProviderRequest;
import com.imedia.service.provider.model.GetProviderRequest;
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
public class ProviderController {
    static final Gson gson = new Gson();
    public final ProviderService providerService;

    public final ProvinceService provinceService;
    @PostMapping ("/listProvider")
    public ResponseEntity<?> getListProvider(@Valid @RequestBody GetProviderRequest request){
//        log.info(new Gson()/to);
        try {
            log.info("========GET LIST PROVIDER========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = providerService.getListProvider(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= LIST PROVIDER EXCEPTION ========" + gson.toJson(request), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }

    }

    @GetMapping("/listProvince")
    public ResponseEntity<?> getListProvice(){
        try {
            BaseResponse response = provinceService.getListProvince();
            log.info("======== GET LIST PROVINCE ========");
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(provinceService.getListProvince());
        } catch (Exception e){
            log.info("========= LIST PROVINCE EXCEPTION ========" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }

    }

    @PostMapping("/createProvider")
    public ResponseEntity<?> createProvider(@Valid @RequestBody CreateProviderRequest request){
        try {
            log.info("======== CREATE PROVIDER ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = providerService.createProvider(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            log.info("========= CREATE PROVIDER EXCEPTION ========" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }

    }
    @PostMapping("/updateProvider")
    public ResponseEntity<?> editProvider (@Valid @RequestBody UpdateProviderRequest request){
        return ResponseEntity.ok().body(providerService.updateProvider(request));
    }
    @PostMapping("/inactiveProvider")
    public ResponseEntity<?> inactiveProvider (@Valid @RequestBody InactiveProviderRequest request){
        log.info("======== INACTIVE PROVIDER ========");
        log.info("====== REQUEST ====== " + gson.toJson(request));
        BaseResponse response = providerService.inactiveProvider(request);
        log.info("====== RESPONSE ====== " + gson.toJson(response));
        return ResponseEntity.ok().body(response);
    }
}
