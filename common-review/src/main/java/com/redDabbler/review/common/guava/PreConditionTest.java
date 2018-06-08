package com.redDabbler.review.common.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Created by whh on 2017/8/23.
 */
public class PreConditionTest {


    // 参数
    @Test
    public void test2() {
        Preconditions.checkArgument(1 == 1);
        Preconditions.checkArgument(1 == 1, "参数校验");
        Preconditions.checkArgument(false, "始终返回");
    }

    //状态
    @Test
    public void checkStat() {
        Preconditions.checkState(true, "状态1");
        Preconditions.checkState(false, "状态2");
    }

    // 下标
    @Test
    public void checkElement() {
        //   Preconditions.checkElementIndex(-1,2);
        Preconditions.checkElementIndex(1, 2);
        //   Preconditions.checkElementIndex(2,2,"下标异常");
        Preconditions.checkElementIndex(2, 2);
    }

    @Test
    public void check() {
        // Preconditions.checkPositionIndex(-1,0);
        //  Preconditions.checkNotNull(null);
        Preconditions.checkNotNull(null, "{1}", "不能空");
    }

}
