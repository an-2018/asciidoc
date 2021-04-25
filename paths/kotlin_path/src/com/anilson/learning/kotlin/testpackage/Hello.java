package com.anilson.learning.kotlin.testpackage;

public class Hello {
    public static int num;

    public static Hello create(){
        return new Hello();
    }

    public void sayHello(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Hello hi = Hello.create();
        hi.sayHello();
    }
}
