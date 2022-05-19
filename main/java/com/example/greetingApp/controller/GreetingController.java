package com.example.greetingApp.controller;


import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import com.example.greetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
     *curl localhost:8080/greeting
     @return={id =1 , content="hello world!}
     * curllocalhost:8080/greeting?name=Karthik
     * @return= { id=2, content="hello Karthik!
     */
    @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*
    *curl localhost:8080/greeting/karthik
    @return={id =1 , content="hello karthik!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private GreetingService greetingService;

    /*
       *curl localhost:8080/greeting/service
       @return={id =1 , content="hello world!}
        */
    @GetMapping("/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }

}
