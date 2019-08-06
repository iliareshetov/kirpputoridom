package com.example.hyperlearner;

import com.example.hyperlearner.model.HomePageCard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HyperLearnerApplication {

	public static Map<String, List<HomePageCard>> homePageCardCacheMap = new HashMap<>();
	public static void main(String[] args) {

		List<HomePageCard> homePageCardList = new ArrayList<>();
		HomePageCard homePageCard1= new HomePageCard();
		homePageCard1.setId(1);
		homePageCard1.setTitle("Become A Seller");
		homePageCard1.setDescription("It's easier than you think , Just Book a table for 1 Week and We will help you sell it.");
		homePageCard1.setAmount("€30");

		HomePageCard homePageCard2= new HomePageCard();
		homePageCard2.setId(2);
		homePageCard2.setTitle("Everything Sells!");
		homePageCard2.setDescription("Be it anything furniture , clothes or utensils .You can also book a table for 2 Weeks.");
		homePageCard2.setAmount("€50");

		HomePageCard homePageCard3= new HomePageCard();
		homePageCard3.setId(3);
		homePageCard3.setTitle("Are You Renovating?");
		homePageCard3.setDescription("If you have a lot of good stuff to give away cause of renovation. Book a table for 1 month and save more.");
		homePageCard3.setAmount("€100");
		homePageCardList.add(homePageCard1);
		homePageCardList.add(homePageCard2);
		homePageCardList.add(homePageCard3);
		homePageCardCacheMap.put("homePageCardList",homePageCardList);

		SpringApplication.run(HyperLearnerApplication.class, args);
	}

}
