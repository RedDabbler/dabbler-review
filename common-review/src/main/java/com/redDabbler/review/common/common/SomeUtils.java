package com.redDabbler.review.common.common;

import java.util.Properties;

public class SomeUtils {

    //

    /** ${key}_${} 根据占位符 的名称获取占位符的值
     *
     */
    public static  String parsePropertyTokens(String string,Properties properties) {
        final String OPEN = "${"; //$NON-NLS-1$
        final String CLOSE = "}"; //$NON-NLS-1$

        String newString = string;
        if (newString != null) {
            int start = newString.indexOf(OPEN);
            int end = newString.indexOf(CLOSE);

            while (start > -1 && end > start) {
                String prepend = newString.substring(0, start);
                String append = newString.substring(end + CLOSE.length());
                String propName = newString.substring(start + OPEN.length(),
                        end);
                String propValue = properties.getProperty(propName);
                if (propValue != null) {
                    newString = prepend + propValue + append;
                }
                start = newString.indexOf(OPEN, end);
                end = newString.indexOf(CLOSE, end);
            }
        }

        return newString;
    }
}
