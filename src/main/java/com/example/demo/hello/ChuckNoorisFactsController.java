package com.example.demo.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class ChuckNoorisFactsController {
    private final ChuckNoorisFactsRepository repository;

    public ChuckNoorisFactsController(final ChuckNoorisFactsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/facts", method= RequestMethod.GET)
    public ChuckNoorisServiceResponse getFacts(){
        final ChuckNoorisServiceResponse response = new ChuckNoorisServiceResponse();
        response.setType("success");
        final List<ChuckNoorisFact> facts = StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
        response.setFacts(facts);
        return response;
    }

    @RequestMapping(value = "/facts/{factId}", method=RequestMethod.GET)
    public ChuckNoorisServiceResponse getFactByFactId(@PathVariable("factId") final Long id) {
        final ChuckNoorisServiceResponse response = new ChuckNoorisServiceResponse();
        response.setType("success");
        final List<ChuckNoorisFact> facts = new ArrayList<>();
        repository.findById(id).ifPresent(facts::add);
        response.setFacts(facts);
        return response;
    }

    private class ChuckNoorisServiceResponse {
        private String type;
        private List<ChuckNoorisFact> facts;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ChuckNoorisFact> getFacts() {
            return facts;
        }

        public void setFacts(List<ChuckNoorisFact> facts) {
            this.facts = facts;
        }
     }
}
