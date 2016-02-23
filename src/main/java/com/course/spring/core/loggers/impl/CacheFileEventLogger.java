package com.course.spring.core.loggers.impl;

import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.course.spring.core.beans.Event;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Value;


public class CacheFileEventLogger extends FileEventLogger {
    @Value("${cacheSize}")
    private int cacheSize;
    private List<Event> events= Lists.newArrayList();


    @Override
    public void logEvent(Event event) {
        events.add(event);

        if (events.size() == cacheSize) {
            writeCacheEventsToFile();
            events.clear();
        }
    }

    private void writeCacheEventsToFile() {
        for (Event event : events) {
            super.logEvent(event);
        }
    }

    private void destroy() {
        if (!events.isEmpty()) {
            writeCacheEventsToFile();
        }
    }
}
