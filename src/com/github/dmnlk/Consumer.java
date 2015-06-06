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


        //compose
        // Function作ってそれにcomposeで追加して新しいFunctionを作る。それにapplyすると両方が適用される
        Function<String, String > wrapDoubleQuote = str -> "\"" + str + "\"";
        Function<String, String > wrapSingleQuote = str -> "'" + str + "'";

        Function<String, String > compose = wrapDoubleQuote.compose(wrapSingleQuote);
        String result = compose.apply("hoge");
        System.out.println(result);
    }
}
