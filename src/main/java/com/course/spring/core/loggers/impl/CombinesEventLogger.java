package com.course.spring.core.loggers.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@Component("defaultLogger")
public class CombinesEventLogger implements EventLogger {
    @Autowired
    private List<EventLogger> loggers;

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
