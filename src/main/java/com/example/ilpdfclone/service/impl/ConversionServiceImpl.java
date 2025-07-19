package com.example.ilpdfclone.service.impl;

import com.example.ilpdfclone.service.ConversionService;
import com.example.ilpdfclone.converter.PdfToPowerPointConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public byte[] convertPdfToPpt(MultipartFile file) throws Exception {
        return PdfToPowerPointConverter.convert(file.getInputStream());
    }

    // Other conversion methods (PDF to Word, etc.) go below...
}
