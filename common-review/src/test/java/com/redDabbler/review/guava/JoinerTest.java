package com.redDabbler.review.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class JoinerTest {

    public void testOn() {
        String str = Joiner.on("_").skipNulls().join(Lists.newArrayList("apple", null, "banana", "orange", "pear"));
        System.out.println(str);

        String str1 = Joiner.on("_").join(Lists.newArrayList("apple", "", "banana", "orange", "pear"));
        System.out.println(str1);

        String str2 = Joiner.on("-").useForNull("null").join(Lists.newArrayList("apple", null, "banana", "orange", "pear"));
        System.out.println(str2);

        StringBuilder stringBuilder = Joiner.on("-").skipNulls().appendTo(new StringBuilder(), Lists.newArrayList("apple", null, "banana", "orange", "pear"));

        System.out.println(stringBuilder.toString());
    }

    public void testSkipNull() {
        Joiner.on("//").skipNulls().skipNulls();
    }


    public void testMapOn() {
        Map map = Maps.newHashMap();
        map.put("1", null);
        map.put(null, null);
        map.put("2", 3);
        String str = Joiner.on("#").useForNull("null").withKeyValueSeparator("=").join(map); //null=null#1=null#2=3
        System.out.println(str);
    }
}
