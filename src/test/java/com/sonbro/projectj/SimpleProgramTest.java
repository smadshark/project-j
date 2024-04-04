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

    @Test
    public void textBlockFormatted() {
        String textBlock = """
                {
                  "id": %d,
                  "name": %s
                }
                """.formatted(11, "goods");

        System.out.println(textBlock);
    }

    @Test
    public void recordTest() {
        Item juice = new Item("juice", 3000);
        System.out.println(juice.name);
        System.out.println(juice.name());
    }

    record Item(String name, int price) {
    }
}
