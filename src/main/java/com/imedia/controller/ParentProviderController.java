package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.model.BaseResponse;
import com.imedia.service.parentprovider.ParentProviderService;
import com.imedia.service.parentprovider.model.CreateParProviderRequest;
import com.imedia.service.provider.model.CreateProviderRequest;
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
public class ParentProviderController {
    static final Gson gson = new Gson();
    public final ParentProviderService parentProviderService;

    @PostMapping("/createParentProvider")
    public ResponseEntity<?> createProvider(@Valid @RequestBody CreateParProviderRequest request){
        try {
            log.info("======== CREATE PARENT PROVIDER ========");
            log.info("====== REQUEST ====== " + gson.toJson(request));
            BaseResponse response = parentProviderService.createParentProvider(request);
            log.info("====== RESPONSE ====== " + gson.toJson(response));
            return ResponseEntity.status(200).body(response);
        } catch (Exception e){
            log.info("========= CREATE PARENT PROVIDER EXCEPTION ========" + gson.toJson(request), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }

    }

}
