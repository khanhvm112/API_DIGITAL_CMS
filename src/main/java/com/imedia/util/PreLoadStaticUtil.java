package com.imedia.util;

import com.google.gson.Gson;
import com.imedia.model.ErrorCode;
import com.imedia.model.ErrorCodeResponse;



import com.imedia.service.user.model.UserInfoAddressData;

import org.apache.logging.log4j.LogManager;
import com.imedia.oracle.dao.AddressDAO;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PreLoadStaticUtil implements CommandLineRunner {
    public static HashMap<Integer, ErrorCodeResponse> errorCodeWeb = new HashMap<>();
    public static HashMap<String, UserInfoAddressData> addresses = new HashMap<>();
    static final Gson gson = new Gson();
    static final Logger logger = LogManager.getLogger(PreLoadStaticUtil.class);
    private final AddressDAO addressDAO;

    public PreLoadStaticUtil(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    private void loadAddress() {
        List<UserInfoAddressData> addressData = addressDAO.getCacheAddress();
        for (UserInfoAddressData userInfoAddressData : addressData) {
            addresses.put(userInfoAddressData.getWardCode(), userInfoAddressData);
//            addressesId.put(userInfoAddressData.getWardId(), userInfoAddressData);
        }
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            loadAddress();
            loadErrorCodes();
//            cacheAddress();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Khởi động lỗi", e);
            System.exit(0);
        }
    }

    private void loadErrorCodes() throws Exception {
        for (ErrorCode value : ErrorCode.values()) {
            errorCodeWeb.put(value.code, new ErrorCodeResponse(value.code, value.message));
        }
    }
}
