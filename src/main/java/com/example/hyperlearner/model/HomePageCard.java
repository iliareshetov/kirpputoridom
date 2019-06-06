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
    @Column(name = "title")
    private String title;
    @Column(name = "amount")
    private String amount;
    @Column(name = "descriptionLine1")
    private String descriptionLine1;
    @Column(name = "descriptionLine2")
    private String descriptionLine2;
    @Column(name = "descriptionLine3")
    private String descriptionLine3;
    @Column(name = "descriptionLine4")
    private String descriptionLine4;

    public String getDescriptionLine1() {
        return descriptionLine1;
    }

    public void setDescriptionLine1(String descriptionLine1) {
        this.descriptionLine1 = descriptionLine1;
    }

    public String getDescriptionLine2() {
        return descriptionLine2;
    }

    public void setDescriptionLine2(String descriptionLine2) {
        this.descriptionLine2 = descriptionLine2;
    }

    public String getDescriptionLine3() {
        return descriptionLine3;
    }

    public void setDescriptionLine3(String descriptionLine3) {
        this.descriptionLine3 = descriptionLine3;
    }

    public String getDescriptionLine4() {
        return descriptionLine4;
    }

    public void setDescriptionLine4(String descriptionLine4) {
        this.descriptionLine4 = descriptionLine4;
    }

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




}
