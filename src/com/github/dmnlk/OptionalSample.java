package com.github.dmnlk;

import java.util.Optional;

/**
 * Created by dmnlk on 2015/04/06.
 */
public class OptionalSample {

    public static void main(String[] args) {

        //java7
        String hoge = getHoge();
        if (hoge != null) {
            System.out.println(hoge);
        }

        //java8
        Optional<String> optionalHoge = Optional.ofNullable(getHoge());
        optionalHoge.ifPresent(s -> System.out.println(s.length()));

        //mapをつかうと値を返せる
        Optional<String> optional = Optional.ofNullable(getHoge());
        Optional<Integer> optInt = optional.map(s -> s.length());
        optInt.ifPresent(i -> System.out.println(i));


        //nullの場合にデフォルト値とか
        Optional<String> host = Optional.ofNullable(getEnv("host"));
        String h = host.orElse("localhost");
        System.out.println(h);
        // メソッド渡せる
        String s = host.orElseGet(() -> "please set host address");
        System.out.println(s);

    }

    public static String getEnv(String envType) {
        return  "127.0.0.1";
    }

    // なんかnull返すかもしれないメソッド
    public static String getHoge() {
        return  "test";
    }
}
