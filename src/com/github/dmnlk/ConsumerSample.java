package com.github.dmnlk;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author dmnlk
 */
public class ConsumerSample {
    public static void main(String[] args) {


        // Function<T, R>
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

        //andThenだと逆順適用
        Function<String, String> andThen = wrapDoubleQuote.andThen(wrapSingleQuote);
        String andThenResult = andThen.apply("hoge");
        System.out.println(andThenResult);

        //identifyは何もしない
        Function<String, String> identify = Function.identity();
        System.out.println(identify.apply("aaaaaa"));

        // ConsumerSample<T>

        // acceptは受け取ったものをそのまま使う
        Consumer<String> consumer = str -> System.out.println("consumer :" + str);
        consumer.accept("hoge");

        //andthenは大体同じ。最後にacceptに食わせる
        Consumer<String> hoge = str -> System.out.println("hoge" + str);
        Consumer<String> fuga = str -> System.out.println("fuga" + str);

        hoge.andThen(fuga).accept("ora");


        //Supplier<T>

        // T型を返す。getで取得出来る
        Supplier<String> supplier = () -> "supplier!";
        System.out.println(supplier.get());
    }
}
