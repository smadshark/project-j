package com.sonbro.projectj.just.ref;

import static com.sonbro.projectj.just.ref.Grade.*;

public class EnumRefMain3 {
    public static void main(String[] args) {
        int price = 10000;
        printDiscount(BASIC, price);
        printDiscount(GOLD, price);
        printDiscount(DIAMOND, price);
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " price: " + grade.discount(price));
    }
}
