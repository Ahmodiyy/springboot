package com.example.springboot;

import component.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController
{
    @Value("${name}")
    String name;


   // @Autowired
    private Coach coach;
    private Coach anotherCoach;
    private Coach swimCoach;

    private Example example;


    @Autowired
    public FunRestController(@Qualifier("cricketCoach") Coach coach,
                             @Qualifier("cricketCoach") Coach anotherCoach,
                             @Qualifier("swim") Coach swimCoach,
                             Example example) {
        this.coach = coach;
        this.anotherCoach = anotherCoach;
        this.swimCoach = swimCoach;
        this.example = example;
        System.out.println("is same : "+ coach.equals(anotherCoach));
    }

    /**
    @Autowired
    public void setCoach(Coach coach){
        this.coach = coach;
    }
    **/

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return name;
    }

    @GetMapping("/getCoach")
    public String getCoach() {
        return swimCoach.getDailyWorkout() + " : "+ example.name ;
    }
}