package com.example.minierpsimulator.repository;

import com.example.minierpsimulator.entity.IncidentTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentTicketRepository extends JpaRepository<IncidentTicket, String> {
}