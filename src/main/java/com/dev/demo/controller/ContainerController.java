package com.dev.demo.controller;
import com.dev.demo.entity.Container;
import com.dev.demo.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/containers")
public class ContainerController {
    @Autowired
    private ContainerService cs;
    @GetMapping("/list")
    public List<Container> getAllContainers() {
        return cs.getAllContainers();
    }
    @PostMapping
    public Container addContainer(@RequestBody Container container) {
        return cs.createContainer(container);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContainer(@PathVariable String id) {
        return new ResponseEntity<>(cs.deleteContainer(id), HttpStatus.OK);
    }
}
