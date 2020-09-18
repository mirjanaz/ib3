package ib.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ib.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	User findByIdd(Long idd);
	
	
	
}
