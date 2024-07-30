
package com.example.superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/superheroes")
    public String getSuperheroes(
            @RequestParam(required = false) String superpower,
            @RequestParam(name = "encrypted", defaultValue = "false") boolean encrypted) {
        List<Superhero> superheroes;

        if (superpower != null && !superpower.isEmpty()) {
            superheroes = superheroService.getSuperheroesBySuperpower(superpower);
        } else {
            superheroes = superheroService.getSuperheroes();
        }

        if (encrypted) {
            superheroes = superheroService.getSuperheroesWithEncryptedIdentities(superheroes);
        }

        return superheroService.getFormattedIdentities(superheroes);
    }
}

