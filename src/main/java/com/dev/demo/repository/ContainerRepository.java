package com.dev.demo.repository;
import com.dev.demo.entity.Container;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContainerRepository extends MongoRepository<Container, String> {
}
