package com.imedia.controller;

import com.google.gson.Gson;
import com.imedia.config.authentication.JwtTokenUtil;
import com.imedia.model.BaseResponse;
import com.imedia.service.product.ProductService;
import com.imedia.service.product.model.GetProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/")
@Log4j2
public class ProductController {
    private final JwtTokenUtil jwtTokenUtil;
    static final Gson gson = new Gson();
    public final ProductService productService;
    @PostMapping("/listProduct")
    public ResponseEntity<?> getListService(@RequestBody GetProductRequest getProductRequest){
//        String tokenUserDetails = jwtTokenUtil.getUserDetailsFromToken(token);
//        CustomUserDetails userDetails = gson.fromJson(tokenUserDetails, CustomUserDetails.class);
        try {
            log.info("========GET LIST PRODUCT========");
            log.info("========REQUEST========"  + "" + gson.toJson(getProductRequest));
            BaseResponse baseResponse = productService.getListProduct(getProductRequest);
            log.info("========RESPONSE========" + gson.toJson(baseResponse));
            return ResponseEntity.ok().body(baseResponse);
        } catch (Exception e){
            log.info("=========LIST PRODUCT EXCEPTION========" + gson.toJson(getProductRequest), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new BaseResponse(500));
        }
    }
}
