package com.redDabbler.review.jdk;


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
        test();
    }
}
