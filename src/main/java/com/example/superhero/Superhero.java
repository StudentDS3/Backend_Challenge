
package com.example.superhero;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

public class Superhero {

    private String name;
    private Identity identity;
    private LocalDate birthday;
    private List<String> superpowers;
    private String formattedIdentity;

    @JsonCreator
    public Superhero(
        @JsonProperty("name") String name,
        @JsonProperty("identity") Identity identity,
        @JsonProperty("birthday") LocalDate birthday,
        @JsonProperty("superpowers") List<String> superpowers) {
        this.name = name;
        this.identity = identity;
        this.birthday = birthday;
        this.superpowers = superpowers;
        this.formattedIdentity = identity.getFirstName() + " " + identity.getLastName();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
        this.formattedIdentity = identity.getFirstName() + " " + identity.getLastName();
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

    public String getFormattedIdentity() {
        return formattedIdentity;
    }

    public void setFormattedIdentity(String formattedIdentity) {
        this.formattedIdentity = formattedIdentity;
    }

    public static class Identity {
        private String firstName;
        private String lastName;

        @JsonCreator
        public Identity(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Getters and setters
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    // Optional: Register JavaTimeModule for LocalDate handling
    public static void registerModule(ObjectMapper mapper) {
        mapper.registerModule(new JavaTimeModule());
    }
}



