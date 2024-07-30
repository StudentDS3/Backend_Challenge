package com.example.superhero;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class SuperheroServiceTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private SuperheroService superheroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadSuperheroes() throws IOException {
        // Prepare mock data
        List<Superhero> mockSuperheroes = new ArrayList<>();
        mockSuperheroes.add(new Superhero("Hero1", new Superhero.Identity("First1", "Last1"), null, List.of("Flying")));
        mockSuperheroes.add(new Superhero("Hero2", new Superhero.Identity("First2", "Last2"), null, List.of("Invisibility")));

        // Mock ObjectMapper behavior
        when(objectMapper.readValue(new ClassPathResource("superheroes.json").getInputStream(), new TypeReference<List<Superhero>>() {}))
                .thenReturn(mockSuperheroes);

        // Manually set the superheroes to avoid loading from a resource
        superheroService.setSuperheroes(mockSuperheroes);

        // Verify results
        List<Superhero> loadedSuperheroes = superheroService.getSuperheroes();
        
        // Add null check
        assertNotNull(loadedSuperheroes, "Loaded superheroes should not be null");
        assertEquals(2, loadedSuperheroes.size(), "The size of loaded superheroes should be 2");
        assertEquals("Hero1", loadedSuperheroes.get(0).getName(), "First superhero's name should be 'Hero1'");
        assertEquals("Hero2", loadedSuperheroes.get(1).getName(), "Second superhero's name should be 'Hero2'");
    }
}
