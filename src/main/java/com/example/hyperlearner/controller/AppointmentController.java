package com.example.hyperlearner.controller;


import com.example.hyperlearner.dto.AppointmentForm;
import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.util.AppUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;




    @GetMapping("/create_booking")
    public String showCreateForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("bookingForm", appointment);
        return "create_booking";
    }


    @PostMapping("/createBooking")
    public String createBooking(@ModelAttribute AppointmentForm bookingForm, Model model) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentReference(appointmentService.getAppointmentRef());
        appointment.setCreateTime(AppUtils.getServerTime());
        appointment.setRevisionTime(AppUtils.getServerTime());
        appointment.setActiveFlag(true);
        appointment.setStatus(1);
        populateAppointment(bookingForm,appointment);
        appointmentService.saveAppointment(appointment);
        model.addAttribute("appointment", appointment);
        return "booking_detail";
    }

    private void populateAppointment(AppointmentForm bookingForm,Appointment appointment){
        appointment.setFirstName(bookingForm.getFirstName());
        appointment.setLastName(bookingForm.getLastName());
        appointment.setEmail(bookingForm.getEmail());
        appointment.setPhoneNumber(bookingForm.getPhoneNumber());
        appointment.setAmount(new BigDecimal(bookingForm.getAmount()));
        appointment.setNumberOfWeeks(Integer.parseInt(bookingForm.getNumberOfWeeks()));
        appointment.setStartDate(AppUtils.parseDateWithoutTimeStamp(bookingForm.getStartDate()));
    }



   /* @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }*/


}
