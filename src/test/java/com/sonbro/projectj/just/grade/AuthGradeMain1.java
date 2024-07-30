package com.sonbro.projectj.just.grade;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        for (AuthGrade authGrade : AuthGrade.values()) {
            System.out.println("grade=" + authGrade.name()
                    + ", level=" + authGrade.getLevel()
                    + ", 설명=" + authGrade.getDesc());
        }
    }
}
