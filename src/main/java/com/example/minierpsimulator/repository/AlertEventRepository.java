package com.example.minierpsimulator.repository;

import com.example.minierpsimulator.entity.AlertEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertEventRepository extends JpaRepository<AlertEvent, String> {
}