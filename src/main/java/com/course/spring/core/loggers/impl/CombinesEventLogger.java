package com.course.spring.core.loggers.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@RequiredArgsConstructor
public class CombinesEventLogger implements EventLogger {
    private final List<EventLogger> loggers;

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
