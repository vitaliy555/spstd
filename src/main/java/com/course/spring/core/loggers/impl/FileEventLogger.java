package com.course.spring.core.loggers.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import lombok.Getter;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@Getter
@Component("fileEventLogger")
public class FileEventLogger implements EventLogger {
    @Value("${filePath}")
    String filePath;
    private File file;
    private boolean canWrite;



    @PostConstruct
    private void init() throws IOException {
        file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        canWrite = file.canWrite();
    }

    public void logEvent(Event event) {
        if (canWrite) {
            try {
                FileUtils.writeStringToFile(file, event.toString(), true);
            } catch (IOException e) {
                System.out.println("Sorry exception found : " + e);
            }
        } else {
            System.out.println("File " + file.getAbsolutePath() + " can't be written");
        }
    }
}
