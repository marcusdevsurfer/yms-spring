package com.dev.demo.repository;

import com.dev.demo.entity.Stack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends MongoRepository<Stack, String> {
}
