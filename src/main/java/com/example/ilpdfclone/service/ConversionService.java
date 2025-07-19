// Path: src/main/java/com/example/ilpdfclone/service/ConversionService.java
package com.example.ilpdfclone.service;

import org.springframework.web.multipart.MultipartFile;

public interface ConversionService {
    byte[] convertPdfToPpt(MultipartFile file) throws Exception;  // Use this method
}
