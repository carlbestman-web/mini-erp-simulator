package com.example.minierpsimulator.service;

import com.example.minierpsimulator.entity.IncidentTicket;
import com.example.minierpsimulator.repository.IncidentTicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class IncidentService {

    private final IncidentTicketRepository incidentTicketRepository;

    public IncidentService(IncidentTicketRepository incidentTicketRepository) {
        this.incidentTicketRepository = incidentTicketRepository;
    }

    public IncidentTicket createIncident(String sourceSystem,
                                         String transactionId,
                                         String errorType,
                                         String severity,
                                         String assignedGroup,
                                         String description) {

        String incidentId = "INC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

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

        return incidentTicketRepository.save(ticket);
    }
}