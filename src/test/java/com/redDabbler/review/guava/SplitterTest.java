package com.redDabbler.review.guava;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by whh on 2017/8/10.
 */
public class SplitterTest {

    @Test
    public void testStringSpilt() {
        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        //parts is [Monday, Tuesday, , Thursday,Friday]
        String[] parts = testString.split(",");
        print(Arrays.asList(parts));
    }

    @Test
    public void testSplitter() {
        String testString = " Monday,Tuesday, ,Thursday,Friday,,";
        Iterator<String> parts = Splitter.on(",").split(testString).iterator();
        print(parts); //Monday,Tuesday,,Thursday,Friday,,
    }

    //trim,对每个截取的字符串做trim处理
    @Test
    public void testTrimResult() {
        String testString = " Monday,Tuesday, ,Thursday,Friday,,";
        Iterator<String> iterator = Splitter.on(',').trimResults().split(testString).iterator();
        print(iterator);//Monday,Tuesday,,Thursday,Friday,,
    }

    // 对截取后获得的空字符串做忽略处理
    @Test
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
