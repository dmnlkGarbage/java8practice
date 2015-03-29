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


        Stream<String> stringStream = Arrays.stream(new String[]{"あ","い","う","え","お"});
        Stream<String> stringStream1 = stringStream.filter(value -> !value.equals("あ"));
        // 一回stream処理したのを2度は使えない、メソッドチェインで次のstreamを処理するように書く
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //stringStream.filter(value -> !value.equals("い"));
        Stream<String> stringStream2 = stringStream1.filter(value -> !value.equals("い"));
        stringStream2.forEach(val -> System.out.println(val));

    }
}
