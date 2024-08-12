package com.sonbro.projectj.just.libsystem;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final int quantity;

    public Library(int quantity) {
        this.quantity = quantity;
    }

    public void addBook(String title, String author) {
        if (books.size() == this.quantity) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }
        books.add(new Book(title, author));
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력==");
        for (Book book : books) {
            System.out.println("title: " + book.title + ", author: " + book.author);
        }
    }

    private record Book(String title, String author) {
    }
}
