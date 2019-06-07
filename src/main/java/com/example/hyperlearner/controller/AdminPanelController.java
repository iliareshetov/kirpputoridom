package com.example.hyperlearner.controller;


import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.service.HomePageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPanelController {

    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private HomePageCardService homePageCardService;


    @GetMapping("/admin/home")
    public ModelAndView adminHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_panel");
        return modelAndView;
    }


    @GetMapping("/booking_list")
    public String showCreateForm() {
        return "booking_list";
    }

}
