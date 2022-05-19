package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingService implements IGreetingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
}
