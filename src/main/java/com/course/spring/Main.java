package com.course.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.spring.core.App;
import com.course.spring.core.beans.Event;
import com.course.spring.core.enums.EventType;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);
        app.logEvent(EventType.ERROR,context.getBean(Event.class));
        app.logEvent(EventType.INFO,context.getBean(Event.class));
        app.logEvent(null,context.getBean(Event.class));
        context.close();
    }
}
