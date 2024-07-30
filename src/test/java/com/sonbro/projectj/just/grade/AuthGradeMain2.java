package com.sonbro.projectj.just.grade;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String grade = scanner.nextLine();
        AuthGrade authGrade = AuthGrade.valueOf(grade.toUpperCase());
        authGrade.printMenu();
    }
}
