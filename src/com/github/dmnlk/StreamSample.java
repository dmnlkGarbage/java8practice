package com.github.dmnlk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by masaki on 2015/03/15.
 */
public class StreamSample {
    public static void main(String[] args) {
        //一行で
        Hello hello = (String str) -> System.out.println(str);
        hello.show("lambda");


        //もっと簡素に
        Hello hello1 = str ->System.out.println(str);
        hello.show("lambda2");

        NoArg noArg = () -> System.out.println("noarg");
        noArg.print();
    }

    // functionalinterfaceアノテーションをつけると、lambdaに使える
    @FunctionalInterface
    private interface Hello {
        public void show(String str);
    }

    // 引数ないメソッドの場合
    @FunctionalInterface
    private interface NoArg {
        public void print();
    }

}
