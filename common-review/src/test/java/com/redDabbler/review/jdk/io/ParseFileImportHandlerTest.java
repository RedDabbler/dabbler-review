package com.redDabbler.review.jdk.io;

import org.junit.Test;

import java.io.File;

public class ParseFileImportHandlerTest {

    ParseFileImportHandler handler = new ParseFileImportHandler();
    @Test
    public void parse() throws Exception{
        handler.parse(new File("E:\\other\\common-template\\common-tools\\src\\main\\java\\com\\redDabbler\\template\\tools\\utils\\BeanHelper.java"));
    }
}