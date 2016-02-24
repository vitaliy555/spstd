package com.course.spring.core.loggers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@Component
public class CombinesEventLogger implements EventLogger {
    @Autowired
    private List<EventLogger> loggers;

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
