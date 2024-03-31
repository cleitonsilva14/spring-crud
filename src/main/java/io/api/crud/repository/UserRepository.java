package io.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.api.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
