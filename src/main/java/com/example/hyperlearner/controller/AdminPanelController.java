package com.example.hyperlearner.controller;
import com.example.hyperlearner.HyperLearnerApplication;
import com.example.hyperlearner.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminPanelController {



    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/admin/home")
    public ModelAndView adminHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_panel");
        return modelAndView;
    }


    @GetMapping("/booking_list")
    public ModelAndView showAllBookings() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("booking_list");
        modelAndView.addObject("appointmentList",appointmentService.getAllAppointments());
        return modelAndView;
    }


    @GetMapping("/clear_cache")
    public ModelAndView clearCacheValues() {
        HyperLearnerApplication.homePageCardCacheMap.clear();
        return adminHome();
    }








}
