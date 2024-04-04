package com.sonbro.projectj;

import org.junit.jupiter.api.Test;

public class SimpleProgramTest {
    @Test
    public void textBlock() {
        String str1 = "hello\n" + "bye\n" + "good";

        System.out.println(str1);

        String str2 = """
                hello
                bye
                good""";

        System.out.println(str2);
    }
}
