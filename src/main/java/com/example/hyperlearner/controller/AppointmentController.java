package com.example.hyperlearner.controller;


import com.example.hyperlearner.components.EmailServiceImpl;
import com.example.hyperlearner.dto.AppointmentForm;
import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.util.AppUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private EmailServiceImpl emailService;




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
        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> emailService.sendSimpleMessage("tawaresaurabh@gmail.com","Appointment Confirmed !!", "Appointment Confirmed with ID "+appointment.getAppointmentReference()));
        executor.shutdown();*/
        return "booking_success";
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


    private void populateAppointmentForm(AppointmentForm bookingForm,Appointment appointment){
        bookingForm.setAppointmentId(appointment.getAppointmentId());
        bookingForm.setFirstName(appointment.getFirstName());
        bookingForm.setLastName(appointment.getLastName());
        bookingForm.setEmail(appointment.getEmail());
        bookingForm.setPhoneNumber(appointment.getPhoneNumber());
        bookingForm.setAmount(appointment.getAmount().toString());
        bookingForm.setNumberOfWeeks(String.valueOf(appointment.getNumberOfWeeks()));
        /*Date dbDate = AppUtils.parseDateWithoutTimeStamp(appointment.getStartDate().toString(),AppUtils.DB_DATE_FORMAT);
        Date uiDate = AppUtils.parseDateWithoutTimeStamp(dbDate.toString(),AppUtils.DB_DATE_FORMAT);
        bookingForm.setStartDate(date.toString());*/

    }

    @GetMapping("/booking_detail")
    public ModelAndView getBookingById(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        modelAndView.addObject("appointment", appointment.get());
        modelAndView.setViewName("booking_detail");
        return modelAndView;
    }

    @GetMapping("/confirmBooking")
    public String confirmBooking(@RequestParam String id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        Appointment appointment1 = appointment.get();
        appointment1.setStatus(2);
        appointment1.setRevisionTime(AppUtils.getServerTime());
        appointmentService.saveAppointment(appointment1);
        return "redirect:/booking_list";
    }


    @GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam String id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/booking_list";
    }

    @GetMapping("/editBooking")
    public ModelAndView editBooking(@RequestParam String id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        Appointment appointment1 = appointment.get();
        AppointmentForm bookingForm = new AppointmentForm();
        ModelAndView modelAndView = new ModelAndView();
        populateAppointmentForm(bookingForm, appointment1);
        modelAndView.addObject("bookingForm", bookingForm);
        modelAndView.setViewName("edit_booking");
        return modelAndView;
    }


    @PostMapping("/updateBooking")
    public String updateBooking(@ModelAttribute AppointmentForm bookingForm, Model model) {
        Optional<Appointment> appointmentOptional = appointmentService.getAppointmentById(bookingForm.getAppointmentId());
        Appointment appointment = appointmentOptional.get();
        appointment.setRevisionTime(AppUtils.getServerTime());
        populateAppointment(bookingForm,appointment);
        appointmentService.saveAppointment(appointment);
        model.addAttribute("appointment", appointment);
        return "redirect:/booking_list";
    }



}
