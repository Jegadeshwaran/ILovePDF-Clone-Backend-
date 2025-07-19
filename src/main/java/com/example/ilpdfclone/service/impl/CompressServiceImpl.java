package com.example.ilpdfclone.service.impl;

import com.example.ilpdfclone.converter.PdfCompressor;
import com.example.ilpdfclone.dto.CompressRequest;
import com.example.ilpdfclone.service.CompressService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CompressServiceImpl implements CompressService {

    @Override
    public byte[] compressPdf(CompressRequest request) {
        try {
            return PdfCompressor.compressPdf(request.getFile().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Failed to compress PDF", e);
        }
    }
}
