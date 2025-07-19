package com.example.ilpdfclone.controller;

import com.example.ilpdfclone.dto.CompressRequest;
import com.example.ilpdfclone.service.CompressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class CompressController {

    private final CompressService compressService;
    /**
     * Endpoint to compress a PDF file.
     *
     * @param file the PDF file to compress
     * @return the compressed PDF file as a byte array
     */

    @PostMapping("/compress")
    public ResponseEntity<byte[]> compressPdf(@RequestParam("file") MultipartFile file) {
        CompressRequest request = new CompressRequest();
        request.setFile(file);

        byte[] result = compressService.compressPdf(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=compressed.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(result);
    }
}
