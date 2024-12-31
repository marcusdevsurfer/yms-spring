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
    private List<Container> containers = new ArrayList<>();

    public Yard() {
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }
    public List<Container> getContainers() {
        return this.containers;
    }
    public void addContainer(Container container) {
        this.containers.add(container);
    }
}
