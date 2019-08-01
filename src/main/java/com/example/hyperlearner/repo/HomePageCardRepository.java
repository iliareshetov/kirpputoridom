package com.example.hyperlearner.repo;

import com.example.hyperlearner.model.HomePageCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("homePageCardRepository")
public interface HomePageCardRepository extends JpaRepository<HomePageCard, Integer> {

}
