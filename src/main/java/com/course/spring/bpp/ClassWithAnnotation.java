package com.course.spring.bpp;

import com.course.spring.bpp.annotation.MyAnnotation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClassWithAnnotation {
    @MyAnnotation
    private String value;

    public ClassWithAnnotation() {
        System.out.println("Create constructor");
    }

    @PostConstruct
    private void init(){
        System.out.println("Called init method");
    }
}
