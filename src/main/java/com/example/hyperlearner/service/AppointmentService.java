package com.example.hyperlearner.service;

import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.repo.AppointmentRepository;
import com.example.hyperlearner.util.AppConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service("appointmentService")
public class AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public Appointment saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(String appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public String getAppointmentRef() {
        Long count = 0L;
        count = appointmentRepository.count();
        count = count + 1;
        String refString = AppConstants.APPOINTMENT_REF_PREFIX + StringUtils.leftPad(count.toString(), 10, "0");
        return refString;
    }



}
