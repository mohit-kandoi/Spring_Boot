package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //Inject Properties for: Coach Name and Team nam
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String teaminfo(){
        return ("Coach Name:- "+coachName+"Team Name:- "+teamName);
    }

    // expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run Daily.";
    }
    @GetMapping("/fortune")
    public String fortuner(){
        return "hahaahah";
    }

}
