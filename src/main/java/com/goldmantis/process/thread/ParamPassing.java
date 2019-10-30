package com.goldmantis.process.thread;

public class ParamPassing {
    private static int intStatic = 222;
    private  int intStatics = 333;

    public static void main(String[] args) {
         int intStatics = 333;
        method(intStatic,intStatics);
        System.out.println(intStatic);
        System.out.println(intStatics);
        method();
        System.out.println(intStatic);
    }
    public static void method(int intStatic,int intStatics){
        intStatic = 777;
        intStatics = 777;
    }
    public static void method(){
        intStatic = 888;
    }
}
