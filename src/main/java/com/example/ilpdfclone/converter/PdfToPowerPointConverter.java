package com.example.ilpdfclone.converter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;

import java.io.*;

public class PdfToPowerPointConverter {

    public static byte[] convert(InputStream inputStream) throws Exception {
        try (PDDocument document = PDDocument.load(inputStream);
             XMLSlideShow ppt = new XMLSlideShow();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            PDFTextStripper stripper = new PDFTextStripper();
            int pageCount = document.getNumberOfPages();

            for (int i = 1; i <= pageCount; i++) {
                stripper.setStartPage(i);
                stripper.setEndPage(i);
                String pageText = stripper.getText(document);

                XSLFSlide slide = ppt.createSlide();
                XSLFTextBox textBox = slide.createTextBox();
                textBox.setAnchor(new java.awt.Rectangle(50, 50, 600, 400));
                textBox.setText(pageText.trim());
            }

            ppt.write(out);
            return out.toByteArray();
        }
    }
}
