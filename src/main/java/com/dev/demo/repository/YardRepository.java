package com.dev.demo.repository;

import com.dev.demo.entity.Yard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YardRepository extends MongoRepository<Yard, String> {

}
