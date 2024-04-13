package com.sonbro.projectj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class JUnitSimpleTest {
    @DisplayName("add")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;

        int sum = 3;

        assertThat(a + b).isEqualTo(sum);
//        assertEquals(sum, a+b);
    }

    @Test
    public void simpleStringTest() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void simpleIntTest() {
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        // 양수 체크
        assertThat(num1).isPositive();
        // 0 체크
        assertThat(num2).isZero();
        // 음수 체크
        assertThat(num3).isNegative();

        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);
    }
}
