package com.example.superhero;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperheroService {
    private List<Superhero> superheroes = new ArrayList<>();
    private final ObjectMapper objectMapper;

    // Constructor injection for ObjectMapper
    public SuperheroService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadSuperheroes() {
        // Register the JavaTimeModule to handle Java 8 date/time types
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // Load sample data from JSON file
            ClassPathResource resource = new ClassPathResource("superheroes.json");
            superheroes = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Superhero>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            superheroes = new ArrayList<>();  // Initialize with empty list on failure
        }
    }

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public List<Superhero> getSuperheroesBySuperpower(String superpower) {
        if (superheroes == null) {
            return new ArrayList<>();
        }
        return superheroes.stream()
                .filter(hero -> hero.getSuperpowers().contains(superpower))
                .collect(Collectors.toList());
    }

    public List<Superhero> getSuperheroesWithEncryptedIdentities() {
        if (superheroes == null) {
            return new ArrayList<>();
        }
        return superheroes.stream()
                .map(this::encryptHeroIdentity)
                .collect(Collectors.toList());
    }

    public List<Superhero> getSuperheroesWithEncryptedIdentities(List<Superhero> heroes) {
        return heroes.stream()
                .map(this::encryptHeroIdentity)
                .collect(Collectors.toList());
    }

    private Superhero encryptHeroIdentity(Superhero hero) {
        String encryptedFirstName = StringEncryption.encrypt(hero.getIdentity().getFirstName());
        String encryptedLastName = StringEncryption.encrypt(hero.getIdentity().getLastName());
        return new Superhero(
                hero.getName(),
                new Superhero.Identity(encryptedFirstName, encryptedLastName),
                hero.getBirthday(),
                hero.getSuperpowers()
        );
    }

    public String getFormattedIdentities(List<Superhero> superheroes) {
        return superheroes.stream()
                .map(Superhero::getFormattedIdentity)
                .collect(Collectors.joining("; "));
    }

    public void setSuperheroes(List<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    public List<Superhero> getAllSuperheroes() {
        return new ArrayList<>(superheroes);
    }
}
