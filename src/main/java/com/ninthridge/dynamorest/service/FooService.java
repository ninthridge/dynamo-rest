package com.ninthridge.dynamorest.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninthridge.dynamorest.model.Foo;
import com.ninthridge.dynamorest.repository.FooRepository;

@Service
public class FooService {
  
  @Autowired
  private FooRepository fooRepository;
  
  public List<Foo> findAll() {
    return fooRepository.findAll();
  }
  
  public Foo findOne(String id) {
    return fooRepository.findOne(id);
  }
  
  public Foo create(Foo foo) {
    return fooRepository.save(foo);
  }
  
  public Foo update(String id, Foo foo) {
    Foo f = fooRepository.findOne(id);
    BeanUtils.copyProperties(foo, f, "id");
    return fooRepository.save(f);
  }
  
  public void delete(String id) {
    fooRepository.delete(id);
  }
}
