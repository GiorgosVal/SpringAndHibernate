package org.example.services.thirdparty;

public class SadFortuneService implements ThirdPartyFortuneService {
    @Override
    public String getFortune() {
        return "Today is NOT your lucky day...";
    }
}
