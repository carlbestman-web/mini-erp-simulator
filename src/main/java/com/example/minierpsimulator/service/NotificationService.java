package com.example.minierpsimulator.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final LoggingService loggingService;

    public NotificationService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public void notifySupport(String severity, String targetGroup, String message) {
        loggingService.log(
                "ALERT",
                "Notify " + targetGroup
                        + " | Severity=" + severity
                        + " | Message=" + message
        );

        System.out.println(
                "[ALERT] Notify " + targetGroup
                        + " | Severity=" + severity
                        + " | Message=" + message
        );
    }
}