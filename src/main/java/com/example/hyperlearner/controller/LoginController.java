package com.example.hyperlearner.controller;

import com.example.hyperlearner.model.Appointment;
import com.example.hyperlearner.model.HomePageCard;
import com.example.hyperlearner.model.User;
import com.example.hyperlearner.service.AppointmentService;
import com.example.hyperlearner.service.HomePageCardService;
import com.example.hyperlearner.service.UserService;
import com.example.hyperlearner.util.AppUtils;
import com.example.hyperlearner.util.ReferenceGenerator;
import com.google.gson.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private HomePageCardService homePageCardService;


    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        int i = 1;
        List<HomePageCard> homePageCardList = homePageCardService.getHomePageCards();
        for(HomePageCard homePageCard:homePageCardList){
            modelAndView.addObject("homePageCard"+i, homePageCard);
            i++;
        }
        modelAndView.setViewName("login");

/*

        String httpsURL = "https://api.instagram.com/v1/users/self/media/recent/?access_token=13299104599.7766668.8b8021f8746848f3b437bfdd4eeace6e";
        try {
            URL myURL = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection)myURL.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            StringBuilder apiJson = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
                apiJson.append(inputLine);
            }
            br.close();
            modelAndView.addObject("apiJson",apiJson.toString());

            JsonParser jsonParser = new JsonParser();
            JsonObject objectFromString = jsonParser.parse(apiJson.toString()).getAsJsonObject();
            JsonElement fullName = objectFromString.get("data");
            modelAndView.addObject("fullName",fullName.getAsString());



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        return modelAndView;
    }



    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}
