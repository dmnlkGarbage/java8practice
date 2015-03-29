package com.github.dmnlk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


        generateTAccountList().stream().mapToInt(e -> e.getAccountId()).forEach(a -> System.out.println(a));
        generateTAccountList().forEach(a -> System.out.println(a));
        double asDouble = generateTAccountList().stream().mapToInt(e -> e.getAccountId()).average().getAsDouble();
        System.out.println(asDouble);

    }
    private static List<TAccount> generateTAccountList() {
        List<TAccount> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TAccount gen = new TAccount(i * 1000, "gen", i + 1);
            list.add(gen);
        }
        return list;
    }
}


class TAccount {
    @Override
    public String toString() {
        return "TAccount{" +
                "accountId=" + accountId +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }

    private int accountId;
    private String nickName;
    private int age;
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TAccount(int accountId, String nickName, int age) {
        this.accountId = accountId;
        this.nickName = nickName;
        this.age = age;
    }
}
