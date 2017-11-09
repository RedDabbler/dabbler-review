package com.redDabble.review.guava;


import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by whh on 2017/8/2.
 */
public class JoinDemo {

    public <A extends Appendable> A appendTo(A appendable, Iterable<Integer> parts) throws IOException {
        return null;
    }

    public <A extends Appendable> A appendTo(A appendable, Iterator<Integer> parts) throws IOException {

        return null;
    }


    private static Iterable<Object> iterable(final Object first, final Object second, final Object[] rest) {
        checkNotNull(rest);
        return new AbstractList<Object>() {
            @Override
            public int size() {
                return rest.length + 2;
            }

            @Override
            public Object get(int index) {
                return null;
            }
        };
    }
}
