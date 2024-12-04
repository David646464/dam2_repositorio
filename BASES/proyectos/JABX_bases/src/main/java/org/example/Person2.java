package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person2 {
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}