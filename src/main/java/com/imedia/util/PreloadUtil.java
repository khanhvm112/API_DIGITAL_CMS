package com.imedia.util;

import com.imedia.model.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Log4j2
public class PreloadUtil implements CommandLineRunner {
    public static HashMap<Integer, ErrorCode> errorCodes = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        try {
            loadStatus();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Khởi động lỗi", e);
            System.exit(0);
        }
    }

    private void loadStatus() {
        for (ErrorCode value : ErrorCode.values()) {
            errorCodes.put(value.code, value);
        }
    }
}
