package com.redDabbler.review.guava;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * Created by whh on 2017/8/14.
 */
@Slf4j
public class StringsTest {

    @Test
    public void testStrings() {
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.emptyToNull(""));
        //用字符补全位数
        System.out.println(Strings.padEnd("123", 10, '0'));
        // 重复字符串
        System.out.println(Strings.repeat("233", 2));
        // 提取相同的前缀
        System.out.println(Strings.commonPrefix("122233","1223"));
        // 提取相同的后缀
        System.out.println(Strings.commonSuffix("122233","1223"));
    }

    @Test
    public void testLimit() {
        List l = Lists.newArrayList(1, 2, 45, 6, 3, 43, 9);
        List m = Lists.newArrayList(1, 45, 4);
        m.retainAll(l);

        log.info("m:{}", m);

    }
}
