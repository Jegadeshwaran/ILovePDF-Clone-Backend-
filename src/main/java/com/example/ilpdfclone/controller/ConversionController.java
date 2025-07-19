package com.example.ilpdfclone.controller;

import com.example.ilpdfclone.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf/convert")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/pdf-to-ppt")
    public ResponseEntity<byte[]> convertPdfToPpt(@RequestParam("file") MultipartFile file) {
        try {
            byte[] pptBytes = conversionService.convertPdfToPpt(file);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition
                    .attachment()
                    .filename("converted.pptx")
                    .build());

            return new ResponseEntity<>(pptBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // you can add other endpoints here too
}
