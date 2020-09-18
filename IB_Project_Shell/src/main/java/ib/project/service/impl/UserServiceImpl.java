package ib.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ib.project.model.User;
import ib.project.repository.UserRepository;



@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
		
    public User findByUsername( String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    public User findByIdd( Long idd ) throws AccessDeniedException {
        User u = userRepository.findByIdd( idd );
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
    
    

}
