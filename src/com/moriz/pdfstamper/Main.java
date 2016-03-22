package com.moriz.pdfstamper;

import org.apache.commons.cli.*;

public class Main {

    public static final String VERSION = "1.0.0";

    public static void main(String[] args) throws Exception {

        Options options = new Options();

        Option input = Option.builder("i")
                .longOpt("input")
                .hasArg()
                .desc("source pdf file to stamp")
                .build();

        Option template = Option.builder("t")
                .longOpt("template")
                .hasArg()
                .desc("template pdf file used for stamping")
                .build();

        Option output = Option.builder("o")
                .longOpt("output")
                .hasArg()
                .desc("output pdf filename")
                .build();

        Option help = Option.builder("h")
                .longOpt("help")
                .build();

        Option version = Option.builder("v")
                .longOpt("version")
                .build();

        options.addOption(input);
        options.addOption(template);
        options.addOption(output);
        options.addOption(help);
        options.addOption(version);

        CommandLine cl = new DefaultParser().parse(options, args, true);

        if (cl.hasOption("v")) {
            System.out.println("pdfstamper " + VERSION);
            System.exit(0);

        } else if (cl.hasOption("h") || cl.getOptions().length == 0) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "pdfstamper", options);
            System.exit(0);

        } else {
            Stamper stamper = new Stamper();

            stamper.setInput(cl.getOptionValue("input"));
            stamper.setTemplate(cl.getOptionValue("template"));
            stamper.setOutput(cl.getOptionValue("output"));

            stamper.stamp();
        }
    }
}
