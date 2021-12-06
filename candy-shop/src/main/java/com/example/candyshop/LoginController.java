package com.example.candyshop;

import javax.validation.Valid;
import java.util.Optional;
import java.time.*; 
import java.util.*;
import lombok.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.Encoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	//NOT USED IN THIS VERSION NEED TO FIGURE THIS OUT LATER

	@Autowired
	private UserRepository userRepo;

	@Data
	class Message{
		private String message;
		public Message(String m) {
			message = m;
		}
	}

	class ErrorMessage{
		private ArrayList<Message> messages = new ArrayList<Message>();
		public void add(String m){
			messages.add(new Message(m));
		}
		public ArrayList<Message> getMessages(){
			return messages;
		}
		public void print(){
			for(Message msg:messages){
				System.out.print(msg.message);
			}
		}
	}


	@GetMapping("/login")
	public String getAction(@ModelAttribute("login") User user, Model model) {
		return "login";
	}


	/**
	@PostMapping("/login")
	public String postAction(@Valid @ModelAttribute("login") User user, Model model, HttpServletRequest request) {
		System.out.println("Start");
		log.info("Logging in " + user);
		User u = userRepo.findByUsername(user.getUsername());
		if(u.getPassword().equals(user.getPassword())) {
			log.info("User logged in " + user);
			return "welcome";
		}
		else {
			return "login";
		}
		return "login";
	}
	**/
}