package com.himi.objecttest;

import org.junit.Test;

/**
 * 面向接口编程
 */
public class ExampleUnitTest {
    @Test
    public void main() {
        /**
         * 常规实现，茶馆与茶叶耦合度太高，只能调用TeaRoom中提供的drinkBlackTea和drinkGreenTea
         * 要是想点其它茶叶，需要修改TeaRoom的代码
         */
        TeaRoom teaRoom = new TeaRoom();
        teaRoom.drinkBlackTea();
        teaRoom.drinkGreenTea();

        /**
         * 依赖倒置解耦
         *
         * 高层模块不依赖底层模块，他们都应该依赖抽象
         * 解释：这里相当于高层模块，底层模块是TeaRoom(茶馆)，我们去茶馆喝茶，应该是我们点什么茶上什么茶（茶是抽象，只能是茶不能点其它不是茶的），
         * 不依赖茶馆的具体实现，茶馆就是提供喝茶的，具体上什么茶取决于点什么茶，只要点的是茶（抽象），就行
         * 接口 ITea 是茶的抽象，高层和底层都是依赖该抽象的
         */
        TeaRoom2 teaRoom2 = new TeaRoom2(new TeaRoom2.IFeel() {
            @Override
            public void feel(String feel) {
                /**
                 * 控制反转
                 *
                 * 比方说去茶馆喝茶，这个主动权是在调用方，也就是我们这里
                 *
                 * 而茶叶好不好喝跟泡茶的方式或者手法是有很大关系的（只考虑客观因素），喝茶的感受跟茶馆有很大的关系
                 * 也就是说感受好与坏，主动权在茶馆，
                 *
                 * 主动权在被调用方就是控制反转，体现在程序上就是 发布/订阅
                 */
                System.out.println(feel);
            }
        });
        /**
         * 依赖注入
         *
         * 通过注入的方式获得依赖
         * A对象依赖于B对象，等价于A对象内部存在对B对象的“调用”，而前提是A对象内部拿到了B对象的引用
         * B对象的引用的来源无非有以下几种：A对象内部创建（无论是作为字段还是作为临时变量）、构造器注入、属性注入、方法注入
         */
        teaRoom2.drinkTea(new BlackTea());
        teaRoom2.drinkTea(new JasmineTea());
        teaRoom2.drinkTea(new GreenTea());
    }
}