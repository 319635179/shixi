package com.shixi.backend.service.pojoservice;

import java.util.Map;

public interface RegisterService {
    public Map<String ,String > register(String username, String password,String confirmedPassword, Map<String, String> data);
}
