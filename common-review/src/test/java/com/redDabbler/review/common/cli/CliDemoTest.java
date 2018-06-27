package com.redDabbler.review.common.cli;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

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