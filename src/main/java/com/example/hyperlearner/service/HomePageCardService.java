package com.example.hyperlearner.service;


import com.example.hyperlearner.model.HomePageCard;
import com.example.hyperlearner.repo.HomePageCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service("homePageCardService")
public class HomePageCardService {

    private HomePageCardRepository homePageCardRepository;

    @Autowired
    public HomePageCardService(HomePageCardRepository homePageCardRepository) {
        this.homePageCardRepository = homePageCardRepository;
    }

   public Optional<HomePageCard> getHomePageCard(Integer number){
       return homePageCardRepository.findById(number);
   }

    public List<HomePageCard> getHomePageCards(){
        return homePageCardRepository.findAll();
    }
}
