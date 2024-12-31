package com.dev.demo.controller;

import com.dev.demo.entity.Container;
import com.dev.demo.entity.Yard;
import com.dev.demo.service.YardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yards")
public class YardController {

    @Autowired
    private YardService ys;

    @GetMapping("/list")
    public ResponseEntity<List<Yard>> getAllYards() {
        return new ResponseEntity<>(ys.getAllYards(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Yard> createYard(@RequestBody Yard yard){
        return new ResponseEntity<>(ys.createYard(yard), HttpStatus.CREATED);
    }

    @PostMapping("/{yardId}/containers")
    public ResponseEntity<String> addContainerToYard(@PathVariable String yardId, @RequestBody Container container){
        Yard updatedYard = ys.addContainerToYard(yardId, container);
        if (updatedYard != null) {
            return new ResponseEntity<>("Contenedor agregado con exito.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No se encontro el patio.",HttpStatus.NOT_FOUND);
    }

}
