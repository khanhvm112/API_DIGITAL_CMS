package com.imedia.service.authenticate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imedia.config.authentication.JwtTokenUtil;
import com.imedia.config.jwt.CustomUserDetails;
import com.imedia.model.ErrorCodeResponse;
import com.imedia.oracle.dao.UsersDAO;
import com.imedia.oracle.repository.AppUserRepository;
import com.imedia.service.user.UserService;
import com.imedia.service.user.model.UserInfoRes;
import com.imedia.util.PreLoadStaticUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AuthenticateService implements UserDetailsService {
    static final Logger logger = LogManager.getLogger(AuthenticateService.class);
    static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    private final JwtTokenUtil jwtTokenUtil;
    private final AppUserRepository appUserRepository;
    private final UserService userService;
    private static final HashMap<Integer, ErrorCodeResponse> errorCodes = PreLoadStaticUtil.errorCodeWeb;
    private final UsersDAO userDao;


    @Autowired
    public AuthenticateService(JwtTokenUtil jwtTokenUtil, AppUserRepository appUserRepository, UserService userService, UsersDAO userDao) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.appUserRepository = appUserRepository;
        this.userService = userService;
        this.userDao = userDao;
    }


    @Override
    public UserDetails loadUserByUsername(String userDetails) throws UsernameNotFoundException {
        CustomUserDetails userDetailsObj = gson.fromJson(userDetails, CustomUserDetails.class);
        UserInfoRes userInfoRes = userDao.getUserInfo(userDetailsObj.getUsername());
        if (userInfoRes != null) {
            return new User(userInfoRes.getUsername(), "",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + userDetails);
        }
    }


//    public SignInResponse login(SignInRequest signInRequest) throws Exception {
//        try {
//            UserInfoRes userInfoRes = userDao.getUserInfo(signInRequest.getUsername());
//            logger.info("====DATA LOGIN ===== " + gson.toJson(userInfoRes));
//            if (userInfoRes != null) {
//                MD5Util md5Util = new MD5Util();
//                String passwordMd5 = userInfoRes.getPasswordMd5();
//                String password = MD5Util.getMd5(signInRequest.getPassword() + userInfoRes.getSalt());
//                if (passwordMd5.equals(password)) {
//                    SignInResponse signInResponse = new SignInResponse();
//                    CustomUserDetails userDetails = new CustomUserDetails(userInfoRes.getId(), signInRequest.getUsername(), signInRequest.getRememberMe(), userInfoRes.getRole(), userInfoRes.getWarehouseId());
//                    String token = jwtTokenUtil.generateToken(userDetails);
//                    signInResponse.setStatus(200);
//                    signInResponse.setMessage("Đăng nhập thành công!");
//                    signInResponse.setToken(token);
//                    //Set Redis
//                    SignInSetCache signInSetCache = new SignInSetCache();
//                    signInSetCache.setToken(token);
//                    signInSetCache.setDeviceId(signInRequest.getDeviceId());
//                    signInSetCache.setUsername(signInRequest.getUsername());
//                    signInSetCache.setUserId(userInfoRes.getId());
//                    signInSetCache.setRequestService(signInRequest.getRequestService());
//                    signInSetCache.setRole(userInfoRes.getRole());
//                    signInSetCache.setName(userInfoRes.getName());
//                    signInSetCache.setWarehouseId(userInfoRes.getWarehouseId());
//                    signInSetCache.setWarehouseName(userInfoRes.getWarehouseName());
//                    handleCacheRemember(signInRequest, signInSetCache);
//
//                    return signInResponse;
//                } else {
//                    return new SignInResponse(PreLoadStaticUtil.errorCodeWeb.get(100).getMessage(), 100);
//                }
//            } else {
//                return new SignInResponse(PreLoadStaticUtil.errorCodeWeb.get(101).getMessage(), 101);
//            }
//        } catch (Exception e) {
//            logger.info("====LOGIN EXCEPTION===== " + gson.toJson(signInRequest), e);
//        }
//        return new SignInResponse(PreLoadStaticUtil.errorCodeWeb.get(500).getMessage(), 500);
//    }
//
//
//    private void handleCacheRemember(SignInRequest signInRequest, SignInSetCache signInSetCache) throws Exception {
//        //Set key to redis
//        if (signInRequest.getKey() != null) {
//            if (signInRequest.getRememberMe() == null)
//                signInRequest.setRememberMe(1);
//            if (signInRequest.getRememberMe() == 0)
//                CallRedis.setCacheExpiry(signInRequest.getKey(), gson.toJson(signInSetCache), 0);
//            else
//                CallRedis.setCacheExpiry(signInRequest.getKey(), AppConfig.getInstance().rememberMeCache, gson.toJson(signInSetCache));
//        }
//    }


}