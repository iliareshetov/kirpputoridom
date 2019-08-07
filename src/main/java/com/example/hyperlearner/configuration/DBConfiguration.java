package com.example.hyperlearner.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;



    @Profile("dev")
    @Bean
    public String devDBConnection(){
        System.out.println("*********DEV connection Enabled**********");
        return  "*********DEV connection Enabled**********";
    }


    @Profile("prod")
    @Bean
    public String prodDBConnection(){
        System.out.println("*********PROD connection Enabled**********");
        return  "*********PROD connection Enabled**********";
    }


}


