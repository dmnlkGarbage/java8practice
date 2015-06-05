package com.github.dmnlk;

import java.util.function.Function;

/**
 * @author dmnlk
 */
public class Consumer {
    public static void main(String[] args) {
        //T型引数を受け取りR型を返す
        Function<String, Integer> function = str -> Integer.parseInt(str);
        System.out.println(function.apply("2"));
    }
}
