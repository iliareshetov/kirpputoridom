package com.example.hyperlearner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "home_page_card")
public class HomePageCard {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private String amount;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
