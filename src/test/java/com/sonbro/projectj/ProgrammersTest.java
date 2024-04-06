package com.sonbro.projectj;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProgrammersTest {
    @Test
    public void findInt() {
        int[] numList = new int[]{1, 2, 3, 4, 5};
        int findNum = 3;
        System.out.println(innerFindInt(numList, findNum));
    }

    public int innerFindInt(int[] numList, int findNum) {
        if (IntStream.of(numList).anyMatch(e -> e == findNum)) {
            return 1;
        }
        return 0;
    }

    @Test
    public void countDownTest() {
        System.out.println(Arrays.toString(countDown(10, 3)));
    }

    public int[] countDown(int start, int endNum) {
        int[] answer = new int[start - endNum + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start--;
        }
        return answer;
    }

    @Test
    public void lower() {
        String str = "aBcDeFg";
        System.out.println(str.toLowerCase());
    }

    @Test
    public void floatToInt() {
        double flo = 1.42;
        System.out.println((int) flo);
    }
}
