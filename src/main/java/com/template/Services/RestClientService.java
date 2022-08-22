package com.template.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
    
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getUserString(int id){
        ResponseEntity<String> response = restTemplate
            .getForEntity("https://jsonplaceholder.typicode.com/users/"+id, String.class);
        
        return response;
    }
}
