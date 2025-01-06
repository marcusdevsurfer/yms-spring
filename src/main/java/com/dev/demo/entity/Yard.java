package com.dev.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "yards")
public class Yard {
    @Id
    private String id;
    private String name;
    private List<Stack> stacks = new ArrayList<>();
    public Yard() {
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public List<Stack> getStacks() {
        return stacks;
    }
    public void setStacks(List<Stack> stacks) {
        this.stacks = stacks;
    }
    public void addStack(Stack stack) {
        stacks.add(stack);
    }
}
