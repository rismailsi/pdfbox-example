package pdftotext.manheim;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class App {

    public static void main(String arg[]) {
        PDFParser parser = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        PDFTextStripper pdfStripper;

        String parsedText;
        String fileName = "/home/rj/Downloads/WorkOrder_17374_0.pdf";
        File file = new File(fileName);
        try {
        	pdDoc = PDDocument.load(file);
            pdfStripper = new PDFTextStripper();
            parsedText = pdfStripper.getText(pdDoc);
            System.out.println("RAW: "+parsedText);
            System.out.println(parsedText.replaceAll("[^A-Za-z0-9. ]+", ""));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (pdDoc != null)
                    pdDoc.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}
