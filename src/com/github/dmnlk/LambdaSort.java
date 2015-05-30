package com.github.dmnlk;

import java.util.Arrays;
import java.util.List;

/**
 * @author dmnlk
 */
public class LambdaSort {
    public static void main(String[] args) {
        List<String> ts = Arrays.asList("a", "bb", "ccc", "d");



        Arrays.sort(ts, (s, t) -> Integer.compare(s.length(), t.length());
    }
}
