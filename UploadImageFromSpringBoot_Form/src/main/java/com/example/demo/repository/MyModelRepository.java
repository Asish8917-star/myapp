package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyModel;

@Repository
public interface MyModelRepository extends CrudRepository<MyModel, Long> {

}
