package com.imedia.config.application;

import java.io.FileInputStream;
import java.util.Properties;

public class AppConfig {
    public String epurse_key;
    public String epurse_service_code;
    public String epurse_url;
    public String epurse_admin_url;
    public String avatarUrl;
    public String imageUrl;
    public String calculateFeeUrl;
    public String mainStackCode;
    public String rewardPointStackCode;
    public String apiAffiliate;
    public String deliveryPackCode;
    public Integer rememberMeCache;
    public Long foodAccountId;
    public Integer orderFee;
    private static AppConfig instance;


    public static void setInstance(AppConfig instance) {
        AppConfig.instance = instance;
    }

    public static AppConfig getInstance() throws Exception {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public AppConfig() throws Exception {
        Properties properties = new Properties();
        String fileName = RootConfig.getInstance().getFile("app_config.cfg");
        FileInputStream fileStream = new FileInputStream(fileName);
        properties.load(fileStream);
        fileStream.close();
        this.epurse_key = properties.getProperty("epurse_key");
        this.epurse_service_code = properties.getProperty("epurse_service_code");
        this.epurse_url = properties.getProperty("epurse_url");
        this.avatarUrl = properties.getProperty("avatarUrl");
        this.imageUrl = properties.getProperty("imageUrl") + "/";
        this.calculateFeeUrl = properties.getProperty("calculateFeeUrl") + "fee";
        this.epurse_admin_url = properties.getProperty("epurse_admin_url");
        this.mainStackCode = properties.getProperty("mainStackCode");
        this.rewardPointStackCode = properties.getProperty("rewardPointStackCode");
        this.apiAffiliate = properties.getProperty("apiAffiliate");
        this.deliveryPackCode = properties.getProperty("deliveryPackCode");
        this.foodAccountId = Long.valueOf(properties.getProperty("foodAccountId"));
        this.rememberMeCache = Integer.valueOf(properties.getProperty("rememberMeCache"));
        this.orderFee = Integer.valueOf(properties.getProperty("orderFee"));
    }
}
