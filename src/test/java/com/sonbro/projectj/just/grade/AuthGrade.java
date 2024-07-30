package com.sonbro.projectj.just.grade;

public enum AuthGrade {
    GUEST(1, "손님"),
    LOGIN(2, "로그인 회원"),
    ADMIN(3, "관리자");

    private final int level;
    private final String desc;

    private final String[] menu = new String[]{"메인 화면", "이메일 관리 화면", "관리자 화면"};

    AuthGrade(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public void printMenu() {
        System.out.printf("your grade is %s\n", desc);
        System.out.println("==메뉴 목록==");
        for (int i = 0; i < level; i++) {
            System.out.println("- " + menu[i]);
        }
    }
}
