package com.sonbro.projectj.domain.te.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Person {
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;
}
