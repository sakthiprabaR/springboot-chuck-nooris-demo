package com.example.demo.hello;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ChuckNoorisFactsRepository {
    private final List<ChuckNoorisFact> facts = new ArrayList<>();
    public ChuckNoorisFactsRepository(){
        facts.add(createFact(10L, "Fact description goes here for fact id 10"));
        facts.add(createFact(8L, "Fact description goes here for fact id 8"));
    }

    public ChuckNoorisFact createFact(long id, String factDescription) {
        ChuckNoorisFact fact = new ChuckNoorisFact();
        fact.setId(id);
        fact.setFact(factDescription);
        return fact;
    }

    public Iterable<ChuckNoorisFact> findAll(){
        return Collections.unmodifiableList(facts);
    }

    public Optional<ChuckNoorisFact> findById(Long id) {
        for (ChuckNoorisFact fact : facts) {
            if(id.equals(fact.getId())) {
                return Optional.of(fact);
            }
        }
        return Optional.empty();
    }
}
