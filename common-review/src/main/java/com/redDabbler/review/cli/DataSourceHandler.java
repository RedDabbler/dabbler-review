package com.redDabbler.review.cli;

import org.apache.commons.cli.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class DataSourceHandler {

    public void handle(String []args)throws ParseException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",
                Locale.getDefault());
        Options opts = new Options();
        opts.addOption("h", false, resourceBundle.getString("HELP_DESCRIPTION"));
        opts.addOption("i", true, resourceBundle.getString("HELP_IPADDRESS"));
        opts.addOption("p", true, resourceBundle.getString("HELP_PORT"));
        opts.addOption("t", true, resourceBundle.getString("HELP_PROTOCOL"));
        CommandLineParser parser = new DefaultParser();
        CommandLine cl;
        try {
            cl = parser.parse(opts, args);
            if (cl.getOptions().length > 0) {
                if (cl.hasOption('h')) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("Options", opts);
                } else {
                    String ip = cl.getOptionValue("i");
                    String port = cl.getOptionValue("p");
                    String protocol = cl.getOptionValue("t");
                    if(!isIPValid(ip))
                    {
                        System.err.println(resourceBundle.getString("INVALID_IP"));
                        System.exit(1);
                    }
                    try {
                        int rc = getDataSource(ip, port, protocol);
                        if (rc == 0) {
                            System.out.println(resourceBundle
                                    .getString("RMDATASOURCE_SUCCEEDED"));
                        } else {
                            System.err.println(resourceBundle
                                    .getString("RMDATASOURCE_FAILED"));
                        }
                    } catch (Exception e) {
                        System.err.println(resourceBundle
                                .getString("RMDATASOURCE_FAILED"));
                        e.printStackTrace();
                    }
                }
            } else {
                System.err.println(resourceBundle.getString("ERROR_NOARGS"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private boolean isIPValid(String ip){
        return false;
    }
    private int getDataSource(String ip, String port, String protocol){
        return 0;
    }
}
