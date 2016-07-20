package com.course.spring.bpp;

import com.course.spring.bpp.annotation.MyAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("postProcessBeforeInitialization");
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("postProcessBeforeInitialization");
            }
        }
        return o;
    }
}
