package com.shixi.backend.service.goods;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface GoodsPhotoService {
    public Map<String, String> addPhoto(MultipartFile multipartFile);
}
