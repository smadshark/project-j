package com.sonbro.projectj;

import org.junit.jupiter.api.Test;

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
}
