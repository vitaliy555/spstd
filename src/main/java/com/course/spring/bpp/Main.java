package com.course.spring.bpp;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bpp.xml");
        ClassWithAnnotation bean = context.getBean(ClassWithAnnotation.class);

    }
}
