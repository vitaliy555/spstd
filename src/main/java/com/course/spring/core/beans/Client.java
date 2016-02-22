package com.course.spring.core.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter@RequiredArgsConstructor
public class Client {
    private final String id;
    private final String fullName;
    private String greeting;
}
