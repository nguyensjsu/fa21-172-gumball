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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/main")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

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

    @GetMapping
    public String home(Model model) {
        System.out.println("testing1");
        model.addAttribute("customers", customerRepository.findAll());
        return "main";
    }

    @GetMapping("/main")
    public String deleteCustomer(@RequestParam Long id) {
        System.out.println("testing2");
        customerRepository.deleteById(id);
        return "main";
    }

    @DeleteMapping(path = "/clear")
    public String clearAllCustomers() {
        customerRepository.deleteAll();
        return "main";
    }
}