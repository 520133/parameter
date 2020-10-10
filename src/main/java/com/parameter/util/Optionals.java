package com.parameter.util;

import java.util.Optional;

/**
 * @author 杨森霖
 * @author 2020/10/10 0010 上午 10:06
 */
public class Optionals {
    public static void main(String[] args) {
        Optional<String> hello = Optional.of("hello");

        //Optional.of(null);  创建值为空的时候抛出异常

        Optional<Object> o = Optional.ofNullable(null);//为空的时候不会抛出空指针
        System.out.println(Optional.ofNullable("1").isPresent());//isPresent可以判断是否存在值
        //System.out.println(Optional.ofNullable(null).get());//有值正常返回，没值抛出异常
        Optional.ofNullable("321").ifPresent(s ->{System.out.println(s);});//有值的时候正常处理，无值的时候不处理
        System.out.println(Optional.ofNullable("1").orElse("123"));//如果有值则将其返回，否则返回指定的其它值
        System.out.println(Optional.ofNullable("12").orElse("hello"));//空值的时候默认值去填充，不为空的时候使用

        String s = Optional.ofNullable("").map(e -> e.toLowerCase()).orElse("senlin");
        System.out.println(s);

        System.out.println(Optional.ofNullable("yangjie").filter(s1 -> s1.equals("yangjie")));

    }
}
