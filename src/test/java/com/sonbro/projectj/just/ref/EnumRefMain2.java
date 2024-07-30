package com.sonbro.projectj.just.ref;

import static com.sonbro.projectj.just.ref.Grade.*;

public class EnumRefMain2 {
    public static void main(String[] args) {
        int price = 10000;
        int basic = BASIC.discount(price);
        int gold = GOLD.discount(price);
        int diamond = DIAMOND.discount(price);

        System.out.println("basic price: " + basic);
        System.out.println("gold price: " + gold);
        System.out.println("diamond price: " + diamond);
    }
}
