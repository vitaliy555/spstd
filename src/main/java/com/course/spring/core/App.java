package com.course.spring.core;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Setter;

import com.course.spring.core.beans.Client;
import com.course.spring.core.beans.Event;
import com.course.spring.core.enums.EventType;
import com.course.spring.core.loggers.EventLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Setter
@Component
public class App {
    private Client client;
    @Qualifier("combinesEventLogger")
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
