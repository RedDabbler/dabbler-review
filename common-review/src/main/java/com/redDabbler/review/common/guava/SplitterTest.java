package com.redDabbler.review.common.guava;

import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class SplitterTest {

    public void testStringSpilt() {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        //parts is [Monday, Tuesday, , Thursday,Friday]
        String[] parts = testString.split(",");
        print(Arrays.asList(parts));
    }

    public void testSplitter() {
        String testString = " Monday,Tuesday, ,Thursday,Friday,,";
        Iterator<String> parts = Splitter.on(",").split(testString).iterator();
        print(parts); //Monday,Tuesday,,Thursday,Friday,,
    }

    //trim,对每个截取的字符串做trim处理
    public void testTrimResult() {
        String testString = " Monday,Tuesday, ,Thursday,Friday,,";
        Iterator<String> iterator = Splitter.on(',').trimResults().split(testString).iterator();
        print(iterator);//Monday,Tuesday,,Thursday,Friday,,
    }

    // 对截取后获得的空字符串做忽略处理
    public void testomitEmptyStrings() {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        Iterator<String> iterator = Splitter.on(',').omitEmptyStrings().split(testString).iterator();
        print(iterator);//Monday,Tuesday,Thursday,Friday
    }

    private void print(List<String> parts) {
        int i = 0;
        for (String str : parts) {
            System.out.print(str);
            i++;
            if (i < parts.size()) {
                System.out.print(",");
            }
        }

        System.out.println();
    }

    private void print(Iterator<?> iterator) {
        if (iterator.hasNext()) {
            System.out.print(iterator.next());
            while (iterator.hasNext()) {
                System.out.print(",");
                System.out.print(iterator.next());
            }
        }
    }
}
