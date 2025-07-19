package com.example.ilpdfclone.dto;

import org.springframework.web.multipart.MultipartFile;

public class ConversionRequest {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
