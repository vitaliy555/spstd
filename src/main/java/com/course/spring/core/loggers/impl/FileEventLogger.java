package com.course.spring.core.loggers.impl;

import java.io.File;
import java.io.IOException;

import lombok.Getter;

import org.apache.commons.io.FileUtils;

import com.course.spring.core.beans.Event;
import com.course.spring.core.loggers.EventLogger;

@Getter
public class FileEventLogger implements EventLogger {
    private File file;
    private boolean canWrite;

    public FileEventLogger(String filePath) throws IOException {
        file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

    }

    private void init() {
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
