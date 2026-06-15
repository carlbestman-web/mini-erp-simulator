package com.example.minierpsimulator.service;

import com.example.minierpsimulator.entity.IncidentTicket;
import com.example.minierpsimulator.repository.IncidentTicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class IncidentService {

    private final IncidentTicketRepository incidentTicketRepository;
    private final AlertService alertService;

    public IncidentService(IncidentTicketRepository incidentTicketRepository,
                           AlertService alertService) {
        this.incidentTicketRepository = incidentTicketRepository;
        this.alertService = alertService;
    }

    public IncidentTicket createIncident(String sourceSystem,
                                         String transactionId,
                                         String errorType,
                                         String severity,
                                         String assignedGroup,
                                         String description) {

        String incidentId = "INC-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();

        IncidentTicket ticket = new IncidentTicket(
                incidentId,
                sourceSystem,
                transactionId,
                errorType,
                severity,
                "OPEN",
                assignedGroup,
                description,
                LocalDateTime.now()
        );

        IncidentTicket savedTicket = incidentTicketRepository.save(ticket);

        alertService.createAlert(
                savedTicket.getIncidentId(),
                severity,
                "TRANSACTION_FAILURE",
                description,
                assignedGroup
        );

        return savedTicket;
    }
}