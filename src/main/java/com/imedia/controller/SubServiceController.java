package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.config.authentication.JwtTokenUtil;
import com.imedia.model.BaseResponse;
import com.imedia.service.subservice.SubServiceService;
import com.imedia.service.subservice.model.CreateSubServiceRequest;
import com.imedia.service.subservice.model.GetSubServiceRequest;
import com.imedia.service.subservice.model.InactiveSubServiceRequest;
import com.imedia.service.subservice.model.UpdateSubServiceRequest;
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

public class SubServiceController {

    private final JwtTokenUtil jwtTokenUtil;
    static final Gson gson = new Gson();
    public final SubServiceService subServiceService;

    @PostMapping("/listSubService")
    public ResponseEntity<?> getListService(@RequestBody GetSubServiceRequest getSubServiceRequest){
//        String tokenUserDetails = jwtTokenUtil.getUserDetailsFromToken(token);
//        CustomUserDetails userDetails = gson.fromJson(tokenUserDetails, CustomUserDetails.class);
        try {
            log.info("======== GET LIST SUBSERVICE ========");
            log.info("====== REQUEST ======"  + "" + gson.toJson(getSubServiceRequest));
            BaseResponse baseResponse = subServiceService.getListService(getSubServiceRequest);
            log.info("====== RESPONSE ======" + gson.toJson(baseResponse));
            return ResponseEntity.ok().body(baseResponse);
        } catch (Exception e){
            log.info("========= LIST SUBSERVICE EXCEPTION ========" + gson.toJson(getSubServiceRequest), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/createSubService")
    public ResponseEntity<?> createService(@Valid @RequestBody CreateSubServiceRequest createSubServiceRequest){
        try {
            log.info("======== CREATE SUBSERVICE ========");
            log.info("====== REQUEST ======" + gson.toJson(createSubServiceRequest));
            BaseResponse baseResponse = subServiceService.createService(createSubServiceRequest);
            log.info("====== RESPONSE ======" + gson.toJson(baseResponse));
            return ResponseEntity.ok().body(baseResponse);
        }catch (Exception e){
            log.info("========= CREATE SUBSERVICE EXCEPTION ========" + gson.toJson(createSubServiceRequest), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/updateSubService")
    public ResponseEntity<?> updateService(@Valid @RequestBody UpdateSubServiceRequest updateServiceRequest) {
        try {
            log.info("======== UPDATE SUBSERVICE ========");
            log.info("====== REQUEST ======" + gson.toJson(updateServiceRequest));
            BaseResponse baseResponse = subServiceService.updateService(updateServiceRequest);
            log.info("====== RESPONSE ======" + gson.toJson(baseResponse));
            return ResponseEntity.ok().body(baseResponse);
        }catch (Exception e){
            log.info("========= UPDATE SUBSERVICE EXCEPTION ========" + gson.toJson(updateServiceRequest), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }

    @PostMapping("/inactiveSubService")
    public ResponseEntity<?> inactiveService(@Valid @RequestBody InactiveSubServiceRequest inactiveSubServiceRequest) {
        try {
            log.info("======== INACTIVE SUBSERVICE ========");
            log.info("====== REQUEST ======" + gson.toJson(inactiveSubServiceRequest));
            BaseResponse baseResponse = subServiceService.inactiveService(inactiveSubServiceRequest);
            log.info("====== RESPONSE ======" + gson.toJson(baseResponse));
            return ResponseEntity.ok().body(baseResponse);
        }catch (Exception e){
            log.info("========= INACTIVE SUBSERVICE EXCEPTION ========" + gson.toJson(inactiveSubServiceRequest), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }
}
