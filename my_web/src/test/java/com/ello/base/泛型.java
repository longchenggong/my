package com.ello.base;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1810:59
 */
public class 泛型 {
    public static <T> void changeT(T[] t, int firstIndex, int secondIndex) {
        T temp = t[firstIndex];
        t[firstIndex] = t[secondIndex];
        t[secondIndex] = temp;
    }

   @Test
    public void changeT() {
        Integer[] i = {1, 2, 3, 5};
        changeT(i, 2, 3);
        System.out.println(Arrays.asList(i));

        String[] s = {"a", "b", "c", "d"};
        changeT(s, 0, 1);
        System.out.println(Arrays.asList(s));
    }
}
