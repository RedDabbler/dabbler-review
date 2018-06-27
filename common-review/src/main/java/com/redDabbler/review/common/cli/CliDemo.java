package com.redDabbler.review.common.cli;

import org.apache.commons.cli.*;


public class CliDemo {

    public static void handleOptions(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("t",false,"display current time");

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options,args);

        if (commandLine.hasOption("t")){
            //
        }
        options.addOption("c",true,"country code");

        String countryCode = commandLine.getOptionValue("c");

    }

    /**
     * Options:
     *   -help                  print this message
     *   -projecthelp           print project help information
     *   -version               print the version information and exit
     *   -quiet                 be extra quiet
     *
     *   -logfile <file>        use given file for log
     *   -logger <classname>    the class which is to perform logging
     *   -D<property>=<value>   use value for given property
     *
     *  -a, --all                  do not hide entries starting with .
     *   -b, --escape               print octal escapes for nongraphic characters
     *       --block-size=SIZE      use SIZE-byte blocks
     */
    public  static void handleOption(String []args){
        // 布尔选项
        Option help = new Option("help","print this message");
        Option projecthelp = new Option("projecthelp","print project help information");
        Option version = new Option("version","print the version information and exit");
        Option quiet = new Option("quiet","be extra quiet");


        // 参数选项

        Option logfile = Option.builder("logfile").argName("file").hasArg().desc("use given file for log").build();
        Option logger = Option.builder("logger").argName("classname").hasArg().desc("the class which is to perform logging").build();

        //Property Option
        Option property = Option.builder("D").argName("property=value")
                .hasArgs().numberOfArgs(2).valueSeparator().desc("use value for given property").build();


        Option a = new Option("a","all",false,"do not hide entries starting with .");
        Option b = new Option("b","escape",false,"print octal escapes for nongraphic characters");

        Option size = Option.builder().longOpt("block-size").desc("use SIZE-byte blocks").hasArg().argName("SIZE").build();
        Options options = new Options();
        options.addOption(help);
        options.addOption(projecthelp);
        options.addOption(version);
        options.addOption(quiet);
        options.addOption(quiet);
        options.addOption(logfile);
        options.addOption(logger);
        options.addOption(property);
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options,args);
            if (commandLine.hasOption("buildfile")){
                String buildFile = commandLine.getOptionValue("buildfile");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HelpFormatter formatter = new HelpFormatter();
        // 打印help
        formatter.printHelp("ant",options,true);

    }

}
