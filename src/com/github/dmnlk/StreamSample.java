package com.github.dmnlk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by masaki on 2015/03/15.
 */
public class StreamSample {
    public static void main(String[] args) {
        Hello hello = (String str) -> System.out.println(str);
        hello.show("lambda");
    }

    // functionalinterfaceアノテーションをつけると、lambdaに使える
    @FunctionalInterface
    private interface Hello {
        public void show(String str);
    }
}
