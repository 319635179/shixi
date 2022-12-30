package com.shixi.backend.service.pojoservice;

import java.util.Map;

public interface LoginService {
    public Map<String ,String > getToken(String username, String password);
}
