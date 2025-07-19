package com.example.ilpdfclone.service.impl;

import com.example.ilpdfclone.converter.PdfSplitter;
import com.example.ilpdfclone.dto.SplitRequest;
import com.example.ilpdfclone.service.SplitService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SplitServiceImpl implements SplitService {

    @Override
    public byte[] splitPdf(SplitRequest request) {
        try {
            return PdfSplitter.splitPdf(
                request.getFile().getInputStream(),
                request.getStartPage(),
                request.getEndPage()
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to split PDF", e);
        }
    }
}
