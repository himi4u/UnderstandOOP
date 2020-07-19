package com.himi.objecttest;

/**
 * 使用依赖倒置原则解耦
 */
public class TeaRoom2 {

    private final IFeel mFeel;

    public TeaRoom2(IFeel feel) {
        this.mFeel = feel;
    }

    public void drinkTea(ITea iTea) { //依赖注入
        String tea = iTea.aboutTea();
        System.out.println("喝了" + tea);

        mFeel.feel(tea + "非常好喝");
    }

    interface IFeel {
        void feel(String feel);
    }
}
