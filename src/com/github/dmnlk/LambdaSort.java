package com.github.dmnlk;

import java.util.Arrays;
import java.util.List;

/**
 * @author dmnlk
 */
public class LambdaSort {
    public static void main(String[] args) {
        List<String> ts = Arrays.asList("a", "bb", "ccc", "d");

        String[] strings = ts.toArray(new String[ts.size()]);

        Arrays.sort(strings, (s, t) -> Integer.compare(s.length(), t.length()));

        Arrays.asList(strings).forEach(System.out::println);
    }
}
