package com.example.hyperlearner.repo;

import com.example.hyperlearner.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    Page<Appointment> findAll(Pageable pageable);
}
