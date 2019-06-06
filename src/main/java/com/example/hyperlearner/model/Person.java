package com.example.hyperlearner.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GenericGenerator(name = "person_id", strategy = "com.example.hyperlearner.util.IdGenerator")
    @GeneratedValue(generator = "person_id")
    @Column(name="person_id")
    private String personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;


}
