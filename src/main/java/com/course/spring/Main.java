package com.course.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.spring.core.App;
import com.course.spring.core.beans.Event;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);
        for (int i = 0; i < 10; i++) {
            app.logEvent(context.getBean(Event.class));
        }
        context.close();
    }
}
