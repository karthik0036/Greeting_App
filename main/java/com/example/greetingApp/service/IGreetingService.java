package com.example.greetingApp.service;

import com.example.greetingApp.dto.UserDto;
import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.model.User;


public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);

    User getById(long id);
}
