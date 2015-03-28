package com.github.dmnlk;

/**
 * Created by masaki on 2015/03/15.
 */
public class LambdaSample {
    public static void main(String[] args) {
        //一行で
        Hello hello = (String str) -> System.out.println(str);
        hello.show("lambda");


        //もっと簡素に
        Hello hello1 = str ->System.out.println(str);
        hello.show("lambda2");

        NoArg noArg = () -> System.out.println("noarg");
        noArg.print();


        Calc calc = (a, b) ->  a + b;
        // このままNullいれると死ぬ
        Integer calcResult = calc.calc(1, 3);
        System.out.println(calcResult);

        // null入れてもおっけー
        Calc nullableCalc = (a, b) -> (a == null || b == null) ? 0 : a + b;
        System.out.println(nullableCalc.calc(null, 2));


        DoSomethingInterface dosome = (a) -> doDosome();
        dosome.doSomething(2);

        GetInterface<DoSomethingInterface> getInterface = () ->(a) -> System.out.println("hello" + a);
        DoSomethingInterface doSomethingInterface = getInterface.get();
        doSomethingInterface.doSomething(2);
    }

    @FunctionalInterface
    public  interface  GetInterface<T> {
        T get();
    }


    private static void doDosome() {
        System.out.println("dodo");
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

    //戻り値あるメソッド
    @FunctionalInterface
    private interface Calc {
        public Integer calc(Integer a, Integer b);
    }

    @FunctionalInterface
    public  interface DoSomethingInterface {
        void doSomething(int a);
    }
}
