package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
//make the class available for dependency injection.
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Practice Bowling for Half Hour.";
    }
}
