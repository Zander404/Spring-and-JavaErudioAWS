package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.entities.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/")
    public Greetings greetings(
            @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        return new Greetings(counter.incrementAndGet(), String.format(template, name));

    }


}
