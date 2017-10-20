package com.ninthridge.dynamorest.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.ninthridge.dynamorest.model.Foo;

@EnableScan
public interface FooRepository extends CrudRepository<Foo, String> {
  List<Foo> findAll();
}
