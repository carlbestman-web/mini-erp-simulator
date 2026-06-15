package com.example.minierpsimulator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AlertEvent {

    @Id
    private String alertId;

    private String incidentId;
    private String severity;
    private String alertType;
    private String message;
    private String targetGroup;
    private String status;
    private LocalDateTime createdAt;

    public AlertEvent() {
    }

    public AlertEvent(String alertId, String incidentId, String severity,
                      String alertType, String message, String targetGroup,
                      String status, LocalDateTime createdAt) {
        this.alertId = alertId;
        this.incidentId = incidentId;
        this.severity = severity;
        this.alertType = alertType;
        this.message = message;
        this.targetGroup = targetGroup;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getAlertId() { return alertId; }
    public String getIncidentId() { return incidentId; }
    public String getSeverity() { return severity; }
    public String getAlertType() { return alertType; }
    public String getMessage() { return message; }
    public String getTargetGroup() { return targetGroup; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setAlertId(String alertId) { this.alertId = alertId; }
    public void setIncidentId(String incidentId) { this.incidentId = incidentId; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    public void setMessage(String message) { this.message = message; }
    public void setTargetGroup(String targetGroup) { this.targetGroup = targetGroup; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}