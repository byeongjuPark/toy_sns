package com.bangil.toy_sns.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

public class FileUploader {
    private String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/files/";

    public String upload(MultipartFile file, String addPath) {
        String folderPath = UPLOADED_FOLDER + addPath + "/";
        String uuid = UUID.randomUUID().toString();
        
        String fileExtension = file.getOriginalFilename().split("\\.")[1];
        try {
            // 폴더 없으면 생성
            if (!Files.exists(Paths.get(folderPath))) {
                Files.createDirectories(Paths.get(folderPath));
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(folderPath + uuid + "." + fileExtension);
            Files.write(path, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return folderPath + uuid + "." + fileExtension;
    }
}
