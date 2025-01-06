package com.dev.demo.service;

import com.dev.demo.entity.Stack;
import com.dev.demo.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StackService {
    @Autowired
    private StackRepository stackRepository;
    public Stack createStack(Stack stack){
        return stackRepository.save(stack);
    }
}
