package com.redDabbler.review.guava;

import com.google.common.base.Preconditions;


public class PreConditionTest {


    // 参数
    public void test2() {
        Preconditions.checkArgument(1 == 1);
        Preconditions.checkArgument(1 == 1, "参数校验");
        Preconditions.checkArgument(false, "始终返回");
    }

    //状态
    public void checkStat() {
        Preconditions.checkState(true, "状态1");
        Preconditions.checkState(false, "状态2");
    }

    // 下标
    public void checkElement() {
        //   Preconditions.checkElementIndex(-1,2);
        Preconditions.checkElementIndex(1, 2);
        //   Preconditions.checkElementIndex(2,2,"下标异常");
        Preconditions.checkElementIndex(2, 2);
    }

    public void check() {
        // Preconditions.checkPositionIndex(-1,0);
        //  Preconditions.checkNotNull(null);
        Preconditions.checkNotNull(null, "{1}", "不能空");
    }

}
