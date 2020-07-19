package com.himi.objecttest;


public class TeaRoom {

    public void drinkBlackTea() {
        System.out.println("喝"+new BlackTea().aboutTea());
    }

    public void drinkGreenTea() {
        System.out.println("喝"+new GreenTea().aboutTea());
    }
}
