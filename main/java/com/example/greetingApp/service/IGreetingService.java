package com.example.greetingApp.service;

import com.example.greetingApp.dto.UserDto;
import com.example.greetingApp.model.Greeting;


public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
}
