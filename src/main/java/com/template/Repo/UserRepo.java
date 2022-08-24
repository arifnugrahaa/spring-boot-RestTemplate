package com.template.Repo;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.template.Model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
    
}
