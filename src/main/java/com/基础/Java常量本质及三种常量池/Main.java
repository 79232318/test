package com.基础.Java常量本质及三种常量池;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        System.out.println(Father.str);
        System.out.println(Sun.str);
        System.out.println(TestValue.str);
    }
}

class Father{
    public static String str = "Hello,world";
    static {
        System.out.println("Father static block");
    }
}


class Sun{
    public static final String str = "Hello,world";
    static {
        System.out.println("Sun static block");
    }
}
/**
 * 从声明本身str都是常量，关键的是这个常量的值能否在编译时期确定下来，
 * 显然这里的例子在编译期的时候显然是确定不下来的。需要在运行期才能能够确定下来，这要求目标类要进行初始化
 */
class TestValue{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("TestValue static code");
    }
}
