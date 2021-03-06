package com.course.spring.core.loggers.impl;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

import org.springframework.stereotype.Component;

@Component("consoleEventLogger")
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
