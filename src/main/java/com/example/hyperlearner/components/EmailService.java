package com.example.hyperlearner.components;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);

}
