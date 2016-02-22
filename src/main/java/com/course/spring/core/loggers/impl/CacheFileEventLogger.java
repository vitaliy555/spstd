package com.course.spring.core.loggers.impl;

import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.course.spring.core.beans.Event;
import com.google.common.collect.Lists;


public class CacheFileEventLogger extends FileEventLogger {
    private final int cacheSize;
    private List<Event> events= Lists.newArrayList();

    public CacheFileEventLogger(String filePath,int cacheSize) throws IOException {
        super(filePath);
        this.cacheSize=cacheSize;
    }

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
