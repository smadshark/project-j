package com.sonbro.projectj.just.ref;

public class DiscountService {
    public int discount(Grade grade, int price) {
        return grade.discount(price);
    }
}
