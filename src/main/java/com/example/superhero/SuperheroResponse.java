package com.example.superhero;
import java.time.LocalDate;
import java.util.List;

public class SuperheroResponse {
    private String name;
    private String identity;
    private LocalDate birthday;
    private List<String> superpowers;

    public SuperheroResponse(String name, String identity, LocalDate birthday, List<String> superpowers) {
        this.name = name;
        this.identity = identity;
        this.birthday = birthday;
        this.superpowers = superpowers;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<String> superpowers) {
        this.superpowers = superpowers;
    }
}
