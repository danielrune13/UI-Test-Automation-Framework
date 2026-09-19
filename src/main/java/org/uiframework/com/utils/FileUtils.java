package org.uiframework.com.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

@Slf4j
public class FileUtils {
    private FileUtils() {
        throw new UnsupportedOperationException("This is an utility class and cannot be instantiaded");
    }
    
    public static File getFileFromLocation(String filePath, String fileName) {
        File dir = new File(filePath);
        for (File file : dir.listFiles()) {
            if (file.getName().contains(fileName)) {
                return file;
            }
        }
        return null;
    }

    public static String[] getPdfContent(File file) {
        try (PDDocument document = Loader.loadPDF(file)) {
            PDFTextStripper tStripper = new PDFTextStripper();
            String pdfFileInText = tStripper.getText(document);
            return pdfFileInText.split("\\r?\\n");
        } catch (IOException e) {
            log.error("Exception while trying to read pdf document - " + e);
            return new String[0];
        }
    }
}
