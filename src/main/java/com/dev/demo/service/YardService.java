package com.dev.demo.service;

import com.dev.demo.entity.Container;
import com.dev.demo.entity.Stack;
import com.dev.demo.entity.Yard;
import com.dev.demo.repository.YardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YardService {
    @Autowired
    private YardRepository yardRepository;
    @Autowired
    private ContainerService containerService;
    @Autowired
    private StackService stackService;

    public List<Yard> getAllYards() {
        System.out.println("Getting yards....");
        return yardRepository.findAll();
    }

    public Yard getYardById(String id) {
        return yardRepository.findById(id).orElse(null);
    }

    public Yard createYard(Yard yard){
        System.out.println("Creating yard....");
        return yardRepository.save(yard);
    }

    public Yard updateYard(String id, Yard yard){
        if(yardRepository.existsById(id)){
            yard.setId(id);
            return yardRepository.save(yard);
        }
        return null;
    }

    public String deleteYard(String id){
        if(!yardRepository.existsById(id)){
            return "Yard with id: " + id + " not found";
        }
        yardRepository.deleteById(id);
        return "Yard with id: " + id + " deleted";
    }

    public Yard addStackToYard(String yardId, Stack stack){
        Yard yard = yardRepository.findById(yardId).orElse(null);
        if(yard != null){
            Stack newStack = stackService.createStack(stack);
            yard.addStack(newStack);
            yardRepository.save(yard);
            return yard;
        }
        return null;
    }

    public Yard addContainerToStackInYard(String yardId, String stackId, Container container) {
        Yard yard = yardRepository.findById(yardId).orElse(null);
        if(yard != null) {
            for(Stack stack : yard.getStacks()){
                if(stack.getId().equals(stackId)){
                    stack.addContainer(container);
                    yardRepository.save(yard);
                    return yard;
                }
            }
        }
        return yard;
    }
}
