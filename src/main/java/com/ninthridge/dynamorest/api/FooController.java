package com.ninthridge.dynamorest.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ninthridge.dynamorest.model.Foo;
import com.ninthridge.dynamorest.service.FooService;

@RestController
@RequestMapping(value = "/foos")
public class FooController {

  protected final Log log = LogFactory.getLog(getClass());

  @Autowired
  private FooService fooService;

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> findAll() {
    try {
      return new ResponseEntity<>(fooService.findAll(), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e, e);
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public @ResponseBody ResponseEntity<?> findOne(@PathVariable("id") String id) {
    try {
      return new ResponseEntity<Foo>(fooService.findOne(id), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e, e);
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> create(@RequestBody Foo foo) {
    try {
      return new ResponseEntity<>(fooService.create(foo), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e, e);
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public @ResponseBody ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Foo foo) {
    try {
      return new ResponseEntity<>(fooService.update(id, foo), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e, e);
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public @ResponseBody ResponseEntity<?> delete(@PathVariable("id") String id) {
    try {
      fooService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      log.error(e, e);
      return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
