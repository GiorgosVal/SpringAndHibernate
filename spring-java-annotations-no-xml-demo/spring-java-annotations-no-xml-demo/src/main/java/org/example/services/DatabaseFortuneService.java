package org.example.services;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "DB fortune service";
    }
}
