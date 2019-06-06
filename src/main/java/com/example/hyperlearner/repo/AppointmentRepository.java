package com.example.hyperlearner.repo;

import com.example.hyperlearner.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
