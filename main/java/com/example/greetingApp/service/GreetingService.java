package com.example.greetingApp.service;

import com.example.greetingApp.dto.UserDto;
import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.model.User;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }


    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
}
