package com.example.greetingApp.service;

import com.example.greetingApp.repository.IGreetingRepository;

import com.example.greetingApp.dto.UserDto;
import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.model.User;
import com.example.greetingApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    //@Autowired
    //IGreetingRepository iGreetingRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public Greeting greetingMessage() {

        return new Greeting(counter.incrementAndGet(), String.format(template));
    }


    @Override
    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        iUserRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public User getById(long id) {
        Optional<User> greetById = iUserRepository.findById(id);
        return greetById.orElse(null);
    }

    @Override
    public List<User> getAllGreetingMessages() {
        return iUserRepository.findAll();
    }
}
