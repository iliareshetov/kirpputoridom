package com.example.hyperlearner;

import com.example.hyperlearner.model.HomePageCard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HyperLearnerApplication {

	public static Map<String, List<HomePageCard>> homePageCardCacheMap = new HashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(HyperLearnerApplication.class, args);
	}

}
