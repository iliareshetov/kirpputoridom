package com.example.hyperlearner.api;

import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminPanelRestController {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/api/booking_list")
    public List<Appointment> showAllBookings() {
        return  appointmentService.getAllAppointments();

    }
}
