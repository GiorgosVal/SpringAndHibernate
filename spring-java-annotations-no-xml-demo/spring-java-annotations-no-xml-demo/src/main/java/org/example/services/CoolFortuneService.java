package org.example.services;

public class CoolFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Dude, this will be a cool day...";
    }
}
