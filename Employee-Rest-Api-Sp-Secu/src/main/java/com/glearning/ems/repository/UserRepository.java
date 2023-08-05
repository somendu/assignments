package com.glearning.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.ems.model.User;

/**
 * 
 * User Repository
 * 
 * @author Aditi Awasthi
 *
 * @since 05-Aug-2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
