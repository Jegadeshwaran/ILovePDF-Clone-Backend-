package com.example.ilpdfclone.dto;

import org.springframework.web.multipart.MultipartFile;

public class SplitRequest {
    private MultipartFile file;
    private int startPage;
    private int endPage;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
