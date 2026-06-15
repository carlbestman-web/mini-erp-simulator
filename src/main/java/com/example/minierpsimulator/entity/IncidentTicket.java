package com.example.minierpsimulator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class IncidentTicket {

    @Id
    private String incidentId;

    private String sourceSystem;
    private String transactionId;
    private String errorType;
    private String severity;
    private String status;
    private String assignedGroup;
    private String description;
    private LocalDateTime createdAt;

    public IncidentTicket() {
    }

    public IncidentTicket(String incidentId,
                          String sourceSystem,
                          String transactionId,
                          String errorType,
                          String severity,
                          String status,
                          String assignedGroup,
                          String description,
                          LocalDateTime createdAt) {
        this.incidentId = incidentId;
        this.sourceSystem = sourceSystem;
        this.transactionId = transactionId;
        this.errorType = errorType;
        this.severity = severity;
        this.status = status;
        this.assignedGroup = assignedGroup;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedGroup() {
        return assignedGroup;
    }

    public void setAssignedGroup(String assignedGroup) {
        this.assignedGroup = assignedGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}