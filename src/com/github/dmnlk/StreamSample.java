package com.github.dmnlk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by masaki on 2015/03/15.
 */
public class StreamSample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        for (Integer a : list) {
            System.out.println(a);
        }
    }
}
