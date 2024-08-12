package com.sonbro.projectj.just.nested;

public class AnonymousMain {
    public static void main(String[] args) {
        AnonymousInter anonymous = new AnonymousInter() {
            @Override
            public void hello() {
                System.out.println("Hello.hello");
            }
        };
        anonymous.hello();
    }
}
