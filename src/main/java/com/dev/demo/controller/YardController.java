package com.dev.demo.controller;

import com.dev.demo.entity.Container;
import com.dev.demo.entity.Stack;
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
    @PostMapping("/{yardId}/stack")
    public ResponseEntity<Yard> addStackToYard(@PathVariable String yardId, @RequestBody Stack stack){
        return new ResponseEntity<>(ys.addStackToYard(yardId, stack), HttpStatus.OK);
    }
}
