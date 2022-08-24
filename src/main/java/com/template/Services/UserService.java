package com.template.Services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.template.Model.UserModel;
import com.template.Repo.UserRepo;
import com.template.dto.User;

@Component
public class UserService {
    
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserRepo userRepo;

    public String test() {
        String result = "";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
    
            HttpEntity<String> entity = new HttpEntity("", header);
            ResponseEntity<String> targetEntity = null;
           targetEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, entity, String.class);
           String response = targetEntity.getBody();
           System.out.println(response);
           
           int codevalue = targetEntity.getStatusCodeValue();

           System.out.println(codevalue);
            
            JSONArray responseArray = new JSONArray(response);
            System.out.println(responseArray.length());
            for (int i = 0; i < responseArray.length();i++ ){
                JSONObject obj = responseArray.getJSONObject(i);
                UserModel user = new UserModel();
                user.setId(obj.getInt("id"));
                user.setEmail(obj.getString("email"));
                user.setName(obj.getString("name"));
                user.setPhone(obj.getString("phone"));
                user.setUsername(obj.getString("username"));
                user.setWebsite(obj.getString("website"));
                userRepo.save(user);
            }
            return result;
    }

    public Iterable<UserModel> cariSemua(){
        return userRepo.findAll();
    }
    
}
