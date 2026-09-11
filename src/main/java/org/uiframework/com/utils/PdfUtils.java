package org.uiframework.com.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader;

import java.io.File;
import java.io.IOException;

public class PdfUtils {

    public static String[] getPdfContent(File file) {
        try (PDDocument document = Loader.loadPDF(file)) {
            PDFTextStripper tStripper = new PDFTextStripper();
            String pdfFileInText = tStripper.getText(document);
            return pdfFileInText.split("\\r?\\n");
        } catch (IOException e) {
            System.err.println("Exception while trying to read pdf document - " + e);
            return new String[0];
        }
    }
}