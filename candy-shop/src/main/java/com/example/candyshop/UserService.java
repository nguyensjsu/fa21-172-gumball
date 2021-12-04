package com.example.candyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public User login(String username, String password) {
		User user = userRepo.findByUsernameAndPassword(username, password);
		return user;
	}
}