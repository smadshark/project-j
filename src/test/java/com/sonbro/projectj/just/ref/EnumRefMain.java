package com.sonbro.projectj.just.ref;

import static com.sonbro.projectj.just.ref.Grade.*;

public class EnumRefMain {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basic = discountService.discount(BASIC, price);
        int gold = discountService.discount(GOLD, price);
        int diamond = discountService.discount(DIAMOND, price);

        System.out.println("basic price: " + basic);
        System.out.println("gold price: " + gold);
        System.out.println("diamond price: " + diamond);
    }
}
