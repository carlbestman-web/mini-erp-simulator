package com.example.minierpsimulator.service;

import com.example.minierpsimulator.entity.AlertEvent;
import com.example.minierpsimulator.repository.AlertEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AlertService {

    private final AlertEventRepository alertEventRepository;
    private final NotificationService notificationService;

    public AlertService(AlertEventRepository alertEventRepository,
                        NotificationService notificationService) {
        this.alertEventRepository = alertEventRepository;
        this.notificationService = notificationService;
    }

    public AlertEvent createAlert(String incidentId,
                                  String severity,
                                  String alertType,
                                  String message,
                                  String targetGroup) {

        String alertId = "ALT-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();

        AlertEvent alert = new AlertEvent(
                alertId,
                incidentId,
                severity,
                alertType,
                message,
                targetGroup,
                "ACTIVE",
                LocalDateTime.now()
        );

        AlertEvent savedAlert = alertEventRepository.save(alert);

        notificationService.notifySupport(
                severity,
                targetGroup,
                message
        );

        return savedAlert;
    }
}