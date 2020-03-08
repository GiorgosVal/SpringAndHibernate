package org.example.services;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String path = "src/main/resources/fortune-data.txt";
    private List<String> data;
    private Random random = new Random();

    @PostConstruct
    public void readFromFile(){
        data = new ArrayList<>();
        File file = new File(path);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String fortune = reader.readLine();
            while (!Objects.isNull(fortune)) {
                data.add(fortune);
                fortune = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getFortune() {
        int index = random.nextInt(data.size());
        return data.get(index);
    }
}
