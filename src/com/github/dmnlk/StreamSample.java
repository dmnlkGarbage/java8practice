package com.github.dmnlk;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by dmnlk on 2015/03/28.
 */
public class StreamSample {
    public static void main(String[] args) {
        String[] values = {"あか","あお","きいろ","みどり","おれんじ"};
        Stream<String> stream = Arrays.stream(values);
        String str = stream.filter(value -> value.contains("あ")).max((v1, v2) -> v1.compareTo(v2)).get();
        System.out.println(str);
    }
}
