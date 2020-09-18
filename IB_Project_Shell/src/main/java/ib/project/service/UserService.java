package ib.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib.project.model.User;
import ib.project.repository.UserRepository;


public interface UserService {
    User findByIdd(Long idd);
    User findByUsername(String username);
    List<User> findAll ();
   
    
    
}
