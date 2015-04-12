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
        // nullなら適当な例外とか
        Optional<String> port = Optional.ofNullable(getEnv("port"));
      //  String po = port.orElseThrow(IllegalArgumentException::new);
//        System.out.println(po);

        TAccountInfo tAccountInfo = new TAccountInfo(1, "name", 2);
        Optional<TAccountInfo> tAccountInfoOptional = Optional.ofNullable(tAccountInfo);
        Optional<Integer> accountId = tAccountInfoOptional.map(TAccountInfo::getAccountId);
        System.out.println(accountId.orElse(-1));


    }

    public static String getEnv(String envType) {
        if (envType.equals("port")) return  null;
        return  "127.0.0.1";
    }

    // なんかnull返すかもしれないメソッド
    public static String getHoge() {
        return  "test";
    }
}

class TAccountInfo {

    private int accountId;
    private String name;
    private int age;

    public TAccountInfo(int accountId, String name, int age) {
        this.accountId = accountId;
        this.name = name;
        this.age = age;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
