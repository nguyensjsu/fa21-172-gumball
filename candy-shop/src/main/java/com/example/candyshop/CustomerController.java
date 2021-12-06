package com.example.candyshop;

import lombok.*;
import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Random;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
// @RequestMapping("/main")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Data
    class Message {
        private String message;

        public Message(String m) {
            message = m;
        }
    }

    class ErrorMessage {
        private ArrayList<Message> messages = new ArrayList<Message>();

        public void add(String m) {
            messages.add(new Message(m));
        }

        public ArrayList<Message> getMessages() {
            return messages;
        }

        public void print() {
            for (Message msg : messages) {
                System.out.print(msg.message);
            }
        }
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String home(Model model) {
        // System.out.println("testing1");
        model.addAttribute("customers", customerRepository.findAll());
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam Long id) {
        // System.out.println("testing2");
        customerRepository.deleteById(id);
        return "redirect:main";
    }

    @RequestMapping(value = "/main/clear", method = RequestMethod.POST)
    public String clearAllCustomers() {
        // System.out.println("testing3");
        customerRepository.deleteAll();
        return "redirect:/main";
    }

    @GetMapping("/adminRegisterCustomer")
    public String getAction(@ModelAttribute("user") User user, Model model) {
        return "adminRegisterCustomer";
    }

    @PostMapping("/adminRegisterCustomer")
    public String postAction(@Valid @ModelAttribute("user") User user, Errors errors, Model model,
            HttpServletRequest request) {

        ErrorMessage msg = new ErrorMessage();
        boolean hasError = false;

        if (user.getFirstname().equals("")) {
            hasError = true;
            msg.add("First name is required!");
        }
        if (user.getLastname().equals("")) {
            hasError = true;
            msg.add("Last name is required!");
        }
        if (user.getEmail().equals("")) {
            hasError = true;
            msg.add("Email is required!");
        }
        if (user.getUsername().equals("")) {
            hasError = true;
            msg.add("Username is required!");
        }
        if (user.getPassword().equals("")) {
            hasError = true;
            msg.add("Password is required!");
        }

        if (hasError) {
            msg.print();
            model.addAttribute("message", "Please enter valid information in the boxes!");
            return "adminRegisterCustomer";
        } else {
            user.setRoles("ROLE_USER");
            userRepository.save(user);
            return "redirect:main";
        }
    }
}