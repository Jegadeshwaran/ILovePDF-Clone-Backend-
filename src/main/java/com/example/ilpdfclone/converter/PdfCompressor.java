package com.example.ilpdfclone.converter;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.*;

public class PdfCompressor {

    public static byte[] compressPdf(InputStream inputStream) throws IOException {
        try (PDDocument document = PDDocument.load(inputStream);
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {

            document.setAllSecurityToBeRemoved(true);

            for (PDPage page : document.getPages()) 
            {
                page.setResources(page.getResources());
            }

            document.save(output);
            return output.toByteArray();
        }
    }
}
