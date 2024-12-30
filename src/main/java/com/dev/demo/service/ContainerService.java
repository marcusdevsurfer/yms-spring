package com.dev.demo.service;

import com.dev.demo.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.demo.entity.Container;
import java.util.List;

@Service
public class ContainerService {
    @Autowired
    private ContainerRepository containerRepository;

    public List<Container> getAllContainers() {
        System.out.println("Getting containers....");
        return containerRepository.findAll();
    }

    public Container getContainerById(String id) {
        return containerRepository.findById(id).orElse(null);
    }

    public Container createContainer(Container container){
        System.out.println("Creating container....");
        return containerRepository.save(container);
    }

    public Container updateContainer(String id, Container container){
        if(containerRepository.existsById(id)){
            container.setId(id);
            return containerRepository.save(container);
        }
        return null;
    }

    public String deleteContainer(String id){
        if(!containerRepository.existsById(id)){
            return "Container with id: " + id + " not found";
        }
        containerRepository.deleteById(id);
        return "Container with id: " + id + " deleted";
    }
}
