package com.example.hyperlearner.controller;

import com.example.hyperlearner.model.HomePageCard;

import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.service.HomePageCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {


    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private HomePageCardService homePageCardService;


    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        int i = 1;
        List<HomePageCard> homePageCardList = homePageCardService.getHomePageCards();
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




}
