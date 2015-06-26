package com.github.dmnlk;

import java.util.function.*;

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

        //Predicate<T>

        //boolean返す
        Predicate<String> predicate = str -> str.isEmpty();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("hoge"));

        //isEqualで同値かを明示的に返す
        Predicate<String> isHoge = Predicate.isEqual("hoge");
        System.out.println(isHoge.test("hoge"));
        System.out.println(isHoge.test("fuga"));

        Predicate<String> isUpperCase = string -> string.matches("[A-Z]+");
        Predicate<String> isAlphabet  = string -> string.matches("[a-zA-Z]+");

        Predicate<String> predic = isAlphabet.and(isUpperCase);

        System.out.println(predic.test("HOGE"));
        System.out.println(predic.test("hoge"));



        Predicate<String> isUpperCase1 = string -> string.matches("[A-Z]+");
        Predicate<String> isNumber    = string -> string.matches("\\d+");

        Predicate<String> predicate2 = isNumber.or(isUpperCase1);

        System.out.println(predicate2.test("HOGE"));
        System.out.println(predicate2.test("1234"));
        System.out.println(predicate2.test("hoge"));

        Predicate<String> isEmpty = string -> string.isEmpty();

        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isNotEmpty.test("hoge"));
        System.out.println(isNotEmpty.test(""));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(Integer::compare);
        int max = maxBy.apply(21, 10);
        System.out.println(max);

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(Integer::compare);
        int min = minBy.apply(21, 10);
        System.out.println(min);

        ToIntFunction<String> getLength = string -> string.length();
        System.out.println(getLength.applyAsInt("hoge"));
    }
}
