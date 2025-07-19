package com.example.ilpdfclone.controller;

import com.example.ilpdfclone.dto.SplitRequest;
import com.example.ilpdfclone.service.SplitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class SplitController {

    private final SplitService splitService;

    @PostMapping("/split")
    public ResponseEntity<byte[]> splitPdf(@RequestParam("file") MultipartFile file,
                                           @RequestParam("startPage") int startPage,
                                           @RequestParam("endPage") int endPage) {
        SplitRequest request = new SplitRequest();
        request.setFile(file);
        request.setStartPage(startPage);
        request.setEndPage(endPage);

        byte[] result = splitService.splitPdf(request);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=split.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(result);
    }
}
