package com.example.demo.hello;

public class ChuckNoorisFact {
    private long id;
    private String fact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    @Override
    public String toString(){
        return String.format("[id=%d,fact=%s]", id, fact);
    }
}
