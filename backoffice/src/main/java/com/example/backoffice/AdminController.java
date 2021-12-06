package com.example.backoffice;

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
import org.springframework.security.core.userdetails.*;

@Slf4j
@Controller
public class AdminController {
    @Autowired
    private AdminRepository adminRepo;

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

    @GetMapping("/register")
    public String getAction( @ModelAttribute("admin") Admin admin, Model model) {
        return "register" ;
    }

    @PostMapping("/register")
    public String postAction(@Valid @ModelAttribute("admin") Admin user, Errors errors, Model model, HttpServletRequest request) {

        ErrorMessage msg = new ErrorMessage();
        boolean hasError = false;

        if(user.getFirstname().equals("")) {
            hasError = true;
            msg.add("First name is required!");
        }
        if(user.getLastname().equals("")) {
            hasError = true;
            msg.add("Last name is required!");
        }
        if(user.getEmail().equals("")) {
            hasError = true;
            msg.add("Email is required!");
        }
        if(user.getUsername().equals("")) {
            hasError = true;
            msg.add("Username is required!");
        }
        if(user.getPassword().equals("")) {
            hasError = true;
            msg.add("Password is required!");
        }

        if(hasError) {
            msg.print();
            model.addAttribute("message", "Please enter valid information in the boxes!");
            return "register";
        } else {
            user.setRoles("ROLE_USER");
            adminRepo.save(user);
            log.info("User created " + user);
            //inMemUserDetManager.createUser(User.withUsername(user.getUsername()).password("{noop}" + user.getPassword()).roles("USER").build());
            return "dashboard";
        }
    }

}
