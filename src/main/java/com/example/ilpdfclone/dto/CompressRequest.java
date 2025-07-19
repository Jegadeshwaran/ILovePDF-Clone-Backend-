package com.example.ilpdfclone.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CompressRequest {
    private MultipartFile file;
}
