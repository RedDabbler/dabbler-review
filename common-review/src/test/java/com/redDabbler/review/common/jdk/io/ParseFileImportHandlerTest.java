package com.redDabbler.review.common.jdk.io;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ParseFileImportHandlerTest {

    ParseFileImportHandler handler = new ParseFileImportHandler();
    @Test
    public void parse() throws Exception{
        handler.parse(new File("E:\\other\\common-template\\common-tools\\src\\main\\java\\com\\redDabbler\\template\\tools\\utils\\BeanHelper.java"));
    }
}