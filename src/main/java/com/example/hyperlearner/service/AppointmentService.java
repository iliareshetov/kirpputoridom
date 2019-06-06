package com.example.hyperlearner.service;

import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.repo.AppointmentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public String getAppointmentRef() {
        String prefix = "APP";
        Long count = 0L;
        count = appointmentRepository.count();
        count = count + 1;
        String refString = prefix + StringUtils.leftPad(count.toString(), 10, "0");
        return refString;
    }
}
