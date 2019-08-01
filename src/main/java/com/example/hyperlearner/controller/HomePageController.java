package com.example.hyperlearner.controller;

import com.example.hyperlearner.HyperLearnerApplication;
import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.model.HomePageCard;
import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.service.HomePageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class HomePageController {


    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private HomePageCardService homePageCardService;


    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        int i = 1;
        List<HomePageCard> homePageCardList = null;
        if(HyperLearnerApplication.homePageCardCacheMap.size() != 0){
            homePageCardList = HyperLearnerApplication.homePageCardCacheMap.get("homePageCardList");
        }else{
            homePageCardList = homePageCardService.getHomePageCards();
            HyperLearnerApplication.homePageCardCacheMap.put("homePageCardList",homePageCardList);
        }
        for(HomePageCard homePageCard:homePageCardList){
            modelAndView.addObject("homePageCard"+i, homePageCard);
            i++;
        }
        modelAndView.setViewName("home");
        return modelAndView;
    }



    @RequestMapping(value={"/gallery"}, method = RequestMethod.GET)
    public ModelAndView getGalleryPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gallery");
        return modelAndView;
    }


    @GetMapping("/create_booking")
    public String showCreateForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("bookingForm", appointment);
        return "create_booking";
    }



}
