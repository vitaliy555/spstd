package com.course.spring.core.beans;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("event")
@Scope(scopeName = "prototype")
public class Event {
    @Autowired
    private DateTime date;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MMMM, yyyy");
    private static String END_LINE = "\n";
    private int id;
    private String msg;

    public boolean isDay() {
        int hourOfDay = date.getHourOfDay();
        return 8 <= hourOfDay && hourOfDay <= 17;
    }

    @Override
    public String toString() {
        return formatter.print(date) + END_LINE;
    }
}
