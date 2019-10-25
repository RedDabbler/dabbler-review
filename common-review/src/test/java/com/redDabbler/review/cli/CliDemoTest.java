package com.redDabbler.review.cli;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

public class CliDemoTest {

    @Test
    public void handleOptions() {
        String[] args = new String[]{"-i","192.168.0.2","-p","5988","-t","http"};
        try {
            CliDemo.handleOptions(args);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
    }

    @Test
    public void handleOption() {
        String[] args = new String[]{"-i","192.168.0.2","-p","5988","-t","http"};
        CliDemo.handleOption(args);
    }

}