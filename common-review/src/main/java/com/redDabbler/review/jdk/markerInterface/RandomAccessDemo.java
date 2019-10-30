package com.redDabbler.review.jdk.markerInterface;

import java.util.*;

/**
 * RandomAccess 是 List 实现所使用的标记接口，用来表明其支持快速（通常是固定时间）随机访问。
 * 此接口的主要目的是允许一般的算法更改其行为，从而在将其应用到随机或连续访问列表时能提供良好的性能。
 *
 * 随机访问
 */
public class RandomAccessDemo {

    /**
     * 初始化 list，添加n个元素
     *
     * @param list
     * @return
     */
    public static <T> List initList(List list, int n) {
        for (int i = 0; i < n; i++)
            list.add(i);
        return list;
    }

    /**
     * 遍历 list，判断是否实现 RandomAccess 接口来使用不同的遍历方法
     *
     * @param list
     */
    public static void accessList(List list) {
        long startTime = System.currentTimeMillis();

        if (list instanceof RandomAccess) {
            System.out.println("实现了 RandomAccess 接口...");
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
        } else {
            System.out.println("没实现 RandomAccess 接口...");
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                iterator.next();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("遍历时间：" + (endTime - startTime));
    }

    /**
     * loop 遍历 list
     */
    public static void accessListByLoop(List list) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("loop遍历时间：" + (endTime - startTime));
    }

    /**
     * 迭代器遍历
     */
    public static void accessListByIterator(List list) {
        long startTime = System.currentTimeMillis();

        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Iterator遍历时间：" + (endTime - startTime));
    }

    public static void main(String[] args) {
        ArrayList<Integer> aList = (ArrayList<Integer>) initList(new ArrayList<>(), 2000000);
        LinkedList<Integer> lList = (LinkedList<Integer>) initList(new LinkedList<>(), 50000);

        accessList(aList);
        accessList(lList);

        System.out.println("ArrayList");
        accessListByLoop(aList);
        accessListByIterator(aList);

        System.out.println("LinkedList");
        accessListByLoop(lList);
        accessListByIterator(lList);
    }


}
