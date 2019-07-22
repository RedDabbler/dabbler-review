package com.redDabbler.review.common.yaml;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import static org.junit.Assert.*;

public class YamlParseTest {

    YamlParse yamlParse = new YamlParse();
    @Test
    public void parseYml() {
        yamlParse.parseYml();
    }

    @Test
    public void parse() {
    }
}