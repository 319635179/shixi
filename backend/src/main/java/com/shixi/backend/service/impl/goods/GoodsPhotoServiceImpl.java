package com.shixi.backend.service.impl.goods;

import com.shixi.backend.mapper.GoodsMapper;
import com.shixi.backend.service.goods.GoodsPhotoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class GoodsPhotoServiceImpl implements GoodsPhotoService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Map<String, String> addPhoto(MultipartFile multipartFile) {
        Map<String, String> map = new HashMap<>();
        if(multipartFile == null){
            map.put("error_message", "文件上传失败");
            return map;
        }
        if(multipartFile.isEmpty()){
            map.put("error_message", "图片不能为空");
            return map;
        }
        if(multipartFile.getSize() > 15 * 1024 * 1024){
            map.put("error_message", "不允许上传大于15MB的照片");
            return map;
        }
        System.out.println(multipartFile.getContentType());
        String filePath = "I:\\study\\shixi\\backend\\src\\main\\resources\\static\\images";
//        文件名
        String fileName = String.valueOf(System.currentTimeMillis()) + '.' +
                Objects.requireNonNull(multipartFile.getContentType()).split("/")[1];
        File file = new File(filePath +File.separator + fileName);
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            IOUtils.copy(multipartFile.getInputStream(),fileOutputStream);
            System.out.println("===========file upload success=======");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("photo_url", "/static/images/" + fileName);
        map.put("error_message", "success");
        return map;
    }
}
