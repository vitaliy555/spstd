package com.course.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    private static String END_LINE = "\n";
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return df.format(date) + END_LINE;
    }
}
