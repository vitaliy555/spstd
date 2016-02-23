package com.course.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(scopeName = "prototype")
public class Event {
    @Autowired
    private Date date;
    @Autowired
    private DateFormat dateFormat;
    private static String END_LINE = "\n";
    private int id;
    private String msg;

    @Override
    public String toString() {
        return dateFormat.format(date) + END_LINE;
    }
}
