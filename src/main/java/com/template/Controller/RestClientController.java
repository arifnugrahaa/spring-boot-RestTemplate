package com.template.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.Services.RestClientService;

@RestController
@RequestMapping("/api/users")
public class RestClientController {
    
    @Autowired
    private RestClientService service;

    @RequestMapping("/{id}")
    public ResponseEntity<String> findUserStringById(@PathVariable("id") int id){
        return service.getUserString(id);
    }
}
