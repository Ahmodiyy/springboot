package com.example.springboot;

import org.springframework.stereotype.Component;

@Component
public class Example {
    public Example() {
        System.out.println("example constructor...");
    }

    String name = "john sam";
}
