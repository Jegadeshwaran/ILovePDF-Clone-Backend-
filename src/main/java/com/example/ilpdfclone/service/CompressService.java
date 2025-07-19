package com.example.ilpdfclone.service;

import com.example.ilpdfclone.dto.CompressRequest;

public interface CompressService {
    byte[] compressPdf(CompressRequest request);
}
