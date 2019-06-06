package com.example.hyperlearner.repo;

import com.example.hyperlearner.model.HomePageCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageCardRepository extends JpaRepository<HomePageCard, Integer> {
    //HomePageCard findById(Integer cardNumber);
}
