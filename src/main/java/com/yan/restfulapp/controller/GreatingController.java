package com.yan.restfulapp.controller;

import com.yan.restfulapp.entity.Greating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreatingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    /*
    Este metodo va a ser un endpoint, es decir, un cliente
    puede acceder a este recurso mediante un petición HTTP
    */
    @GetMapping("/greeting")
    public Greating helloWord(@RequestParam(value="name", defaultValue = "world") String name) {
        return new Greating(counter.incrementAndGet(), String.format(template, name));
    }
}
