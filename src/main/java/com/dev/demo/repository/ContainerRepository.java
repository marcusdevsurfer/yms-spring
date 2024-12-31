package com.dev.demo.repository;
import com.dev.demo.entity.Container;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends MongoRepository<Container, String> {
}
