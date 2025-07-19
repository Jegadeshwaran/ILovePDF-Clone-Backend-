package com.example.ilpdfclone.service;

import com.example.ilpdfclone.dto.SplitRequest;

public interface SplitService {
    byte[] splitPdf(SplitRequest request);
}
