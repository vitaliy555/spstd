package com.course.spring.core.beans;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Client {
    @Value("${id}")
    private String id;
    @Value("${fullName}")
    private String fullName;
    @Value("${greeting}")
    private String greeting;
}
