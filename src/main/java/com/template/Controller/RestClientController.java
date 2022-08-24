package com.template.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.Model.UserModel;
import com.template.Services.RestClientService;
import com.template.Services.UserService;
import com.template.dto.User;

@RestController
@RequestMapping("/api/users")
public class RestClientController {
    
    @Autowired
    private RestClientService service;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> findUserStringById(@PathVariable("id") int id){
        return service.getUserString(id);
    }

    @GetMapping("/object/{id}")
    public ResponseEntity<User> findUserObjectById(@PathVariable("id") int id){
        return service.getUserObject(id);
    }

    @GetMapping
    public ResponseEntity<?> findAllUser(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        return service.postUserObject(user);
    }

    @GetMapping("/simpan")
    public String simpan(){
        String result = "";
        result = userService.test();
        return result;
    }

    @GetMapping("/semua")
    public Iterable<UserModel> semua(){
        Iterable<UserModel> hasil = userService.cariSemua();
        return hasil;
    }
}
