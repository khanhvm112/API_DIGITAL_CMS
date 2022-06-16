package com.imedia.service.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imedia.oracle.repository.AppUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();


    private final AppUserRepository appUserRepository;


    @Autowired

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
}
