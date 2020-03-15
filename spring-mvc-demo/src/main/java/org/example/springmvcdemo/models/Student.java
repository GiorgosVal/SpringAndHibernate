package org.example.springmvcdemo.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String name;
    private String lastName;
    private String country;
    private String favoriteLesson;

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    private List<String> operatingSystems;

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    private String favoriteFood;

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    private String favoriteLanguage;

    public String getFavoriteCar() {
        return favoriteCar;
    }

    public void setFavoriteCar(String favoriteCar) {
        this.favoriteCar = favoriteCar;
    }

    private String favoriteCar;
    private Map<String, String> lessonOptions;

    public Student() {
        lessonOptions = new HashMap<>();
        lessonOptions.put("PHY", "Physics");
        lessonOptions.put("MTH", "Mathematics");
        lessonOptions.put("PRG", "Programming");
        lessonOptions.put("GEO", "Geography");
        lessonOptions.put("GYM", "Gymnastics");
        lessonOptions.put("LIT", "Literature");
        lessonOptions.put("CHΕ", "Chemistry");
        lessonOptions.put("BIO", "Biology");
        lessonOptions.put("PHL", "Philosophy");
        lessonOptions.put("LAT", "Latin");
        lessonOptions.put("AGR", "Ancient Greek");
        lessonOptions.put("PSY", "Psychology");
        lessonOptions.put("SOC", "Sociology");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getLessonOptions() {
        return lessonOptions;
    }

    public String getFavoriteLesson() {
        return favoriteLesson;
    }

    public void setFavoriteLesson(String favoriteLesson) {
        this.favoriteLesson = favoriteLesson;
    }
}
