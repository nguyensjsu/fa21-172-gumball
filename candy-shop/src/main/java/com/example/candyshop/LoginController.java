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
@RequestMapping(value={"/login"})
public class LoginController {

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


	//@GetMapping
	//public String login(@ModelAttribute("login") User user, Model model) {
	//	log.info("Logging in " + user);
	//	return "login";
	//}

	@PostMapping
	public String validLogin(@ModelAttribute("login") User user, Model model) {
		System.out.println("Start");
		User u = userRepo.findByUsername(user.getUsername());
		if(u.getPassword().equals(user.getPassword())) {
			log.info("User logged in " + user);
			return "welcome";
		}
		else {
			return "login";
		}
	} 
}