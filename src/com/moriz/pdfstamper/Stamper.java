package com.moriz.pdfstamper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;


public class Stamper {

    protected String input;
    protected String template;
    protected String output;

    public void setInput(String name) {
        this.input = name;
    }

    public String getInput() {
        return this.input;
    }

    public void setTemplate(String name) {
        this.template = name;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setOutput(String name) {
        this.output = name;
    }

    public String getOutput() {
        return this.output;
    }

    public void stamp() throws Exception {
        this.validate();

        // see: http://stackoverflow.com/a/9382212
        //
        PDDocument realDoc = PDDocument.load(new File(this.getInput()));

        HashMap<Integer, String> overlayGuide = new HashMap<Integer, String>();
        for (int i = 0; i < realDoc.getNumberOfPages(); i++) {
            overlayGuide.put(i + 1, this.getTemplate());
            //watermark.pdf is the document which is a one page PDF with your watermark image in it.
            //Notice here, you can skip pages from being watermarked.
        }

        Overlay overlay = new Overlay();
        overlay.setInputPDF(realDoc);
        overlay.setOverlayPosition(Overlay.Position.FOREGROUND);

        PDDocument outputDoc = overlay.overlay(overlayGuide);

        outputDoc.save(this.getOutput());
    }


    public void validate() {
        ArrayList<String> errors = new ArrayList<String>();

        if (this.getInput() == null) {
            errors.add("Input file is not specified  (--input <file>)");
        }

        if (this.getTemplate() == null) {
            errors.add("Template is not specified    (--template <file>)");
        }

        if (this.getOutput() == null) {
            errors.add("Output file is not specified (--output <file>)");
        }


        if (!errors.isEmpty()) {
            System.out.println("Errors:\n=============");
            for (String error: errors) {
                System.out.println("- " + error);
            }
            System.exit(100);
        }
    }
}
