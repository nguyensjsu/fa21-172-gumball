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
@RequestMapping(path = "/main")
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
        model.addAttribute("customer", new Customer());
        return "main";
    }

    @GetMapping("/search")
    public String search(Model model) {
        System.out.println("Search Success");
        model.addAttribute("customer", new Customer());
        return "search";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute Customer customer, Model model) {
        System.out.println("customerID: " + customer.getCustomerEmail());
        Iterable<Customer> customers = customerRepository.findAll();
        Customer found = new Customer();
        for (Customer c : customers) {
            if (c.getCustomerEmail().equals(customer.getCustomerEmail()))
                found = c;
        }

        if (found.getCustomerEmail() == null || found.getCustomerEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer not found!");
        } else {
            model.addAttribute("customer", customer);
            model.addAttribute("firstname", found.getFirstName());
            model.addAttribute("lastname", found.getLastName());
        }
        return "backoffice";
    }

    @RequestMapping(value = "/customers")
    public String getAllCustomers(Model model) {
        Iterable<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        System.out.println("Success");
        return "search_result";
    }

    @DeleteMapping(path = "/clear")
    public String clearAllCustomer() {
        customerRepository.deleteAll();
        return "main";
    }
}