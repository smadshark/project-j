package com.sonbro.projectj.just.ref;

public class EnumRefMain4 {
    public static void main(String[] args) {
        int price = 10000;
        for (Grade grade : Grade.values()) {
            printDiscount(grade, price);
        }
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " price: " + grade.discount(price));
    }
}
