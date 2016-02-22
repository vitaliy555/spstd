package com.course.spring.core;

import java.util.Map;

import lombok.AllArgsConstructor;

import com.course.spring.core.beans.Client;
import com.course.spring.core.beans.Event;
import com.course.spring.core.enums.EventType;
import com.course.spring.core.loggers.EventLogger;

@AllArgsConstructor
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public void logEvent(EventType eventType, Event event) {
        EventLogger logger = loggers.get(eventType);
        if (logger==null){
            logger=defaultLogger;
        }
        logger.logEvent(event);
    }
}
