package com.example.ilpdfclone.converter;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDPageTree;


import java.io.*;

public class PdfSplitter {

    public static byte[] splitPdf(InputStream inputStream, int start, int end) throws IOException {
        try (PDDocument document = PDDocument.load(inputStream);
             PDDocument splitDoc = new PDDocument();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            PDPageTree pages = document.getPages();
            int index = 0;

            for (PDPage page : pages) {
                if (index >= (start - 1) && index < end) {
                    splitDoc.addPage(page);
                }
                index++;
            }

            splitDoc.save(out);
            return out.toByteArray();
        }
    }
}
