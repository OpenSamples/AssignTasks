package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	/* NOTE: hard-coded role name to be 'USER' and performs only one call to DB which filters only USER roles */ 
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles r WHERE r.name LIKE 'USER' AND u.name LIKE :name")
	List<User> findByNameLike(String name);
	
}
