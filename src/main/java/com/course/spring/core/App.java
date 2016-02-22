package com.course.spring.core;

import lombok.AllArgsConstructor;

import com.course.spring.core.beans.Client;
import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@AllArgsConstructor
public class App {

    private Client client;
    private EventLogger logger;

    public void logEvent(Event event) {
        logger.logEvent(event);
    }
}
