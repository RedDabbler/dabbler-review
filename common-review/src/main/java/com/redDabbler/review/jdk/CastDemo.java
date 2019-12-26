package com.redDabbler.review.jdk;


import java.math.BigDecimal;

public class CastDemo {

    public static void test(){
        Object[] values = new Object[3];
        values[0] = 1243;
        int count = 0;
        for (Object value : values) {
            if (value != null) {
                count=count+(int)value;

            }
        }
        System.out.println(count);
    }

    /**
     * shift operator
     */
    public static void testValue(){
        System.out.printf("2<<2 value: %d\n",2<<2);
        System.out.println(2<<2);
        System.out.println(2>>1);
    }

    public static void  main(String[]args){

     //   testValue();
     //   test();

        testConvert();
    }

    public static void testConvert(){
        BigDecimal bd = new BigDecimal("3.402560103E11");

        String str = bd.toBigInteger().toString();
        int a = Integer.parseInt(str);
        System.out.println(a);


    }
}
