package com.glearning.ems.util;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.ems.model.Role;
import com.glearning.ems.model.User;
import com.glearning.ems.repository.UserRepository;

@Configuration
public class SecurityDataDetails {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		User userOne = new User("Aditi", this.passwordEncoder.encode("aditi"));
		User userTwo = new User("Somendu", this.passwordEncoder.encode("somendu"));
		User userThree = new User("Rahul", this.passwordEncoder.encode("rahul"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		Role superAdminRole = new Role("ROLE_SUPER_ADMIN");

		userOne.addRole(userRole);

		userTwo.addRole(userRole);
		userTwo.addRole(adminRole);

		userThree.addRole(userRole);
		userThree.addRole(adminRole);
		userThree.addRole(superAdminRole);

		this.userRepository.save(userOne);
		this.userRepository.save(userTwo);
		this.userRepository.save(userThree);

	}

}
