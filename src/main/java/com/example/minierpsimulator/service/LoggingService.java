package com.example.minierpsimulator.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class LoggingService {

    private static final String LOG_FILE = "/logs/erp.log";

    public void log(String level, String message) {

        try (FileWriter writer =
                     new FileWriter(LOG_FILE, true)) {

            writer.write(
                    LocalDateTime.now()
                            + " [" + level + "] "
                            + message
                            + System.lineSeparator()
            );

        } catch (IOException e) {

            System.out.println(
                    "Failed to write log file");
        }
    }
}