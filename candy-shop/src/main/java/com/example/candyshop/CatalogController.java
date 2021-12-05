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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Data
    class Message{
        private String message;
        public Message(String m) {
            message = m;
        }
    }

    class ErrorMessage {
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

    @Autowired
	private CatalogCommandRepository catalogRepo;

    @GetMapping
    public String getAction( @ModelAttribute("catalog") Catalog catalog, Model model) {
    	return "catalog" ;
    }
    
    @PostMapping
    public String postAction(@Valid @ModelAttribute("catalog") Catalog catalog, Errors errors, Model model, RedirectAttributes redirectAttrs) {
        ErrorMessage msg = new ErrorMessage();

        // Ensure that inputs only recieve numbers
        if (!catalog.sourPatchKids().matches("[0-9]+")) {
            msg.add("Sour Patch Kids - Invalid Input");
        }
        if (!catalog.hershey().matches("[0-9]+")) {
            msg.add("Hershey - Invalid Input");
        }
        if (!catalog.nerds().matches("[0-9]+")) {
            msg.add("Nerds - Invalid Input");
        }
        if (!catalog.skittles().matches("[0-9]+")) {
            msg.add("Skittles - Invalid Input");
        }

        // If error is found do not redirect to payment
        if (msg.messages.size() > 0) {
            msg.print();
    		model.addAttribute("message", "Please enter valid information in the boxes!");
            return "catalog";
        }

        // Each Item Count
        redirectAttrs.addFlashAttribute("sourPatchKidsCount", catalog.sourPatchKids());
        redirectAttrs.addFlashAttribute("hersheyCount", catalog.hershey());
        redirectAttrs.addFlashAttribute("nerdsCount", catalog.nerds());
        redirectAttrs.addFlashAttribute("skittlesCount", catalog.skittles());

        // Each Item Total Price
        redirectAttrs.addFlashAttribute("sourPatchKidsCost", catalog.individualCost("Sour Patch Kids", catalog.sourPatchKids()));
        redirectAttrs.addFlashAttribute("hersheyCost", catalog.individualCost("Hershey", catalog.hershey()));
        redirectAttrs.addFlashAttribute("nerdsCost", catalog.individualCost("Nerds", catalog.nerds()));
        redirectAttrs.addFlashAttribute("skittlesCost", catalog.individualCost("Skittles", catalog.skittles()));
        redirectAttrs.addFlashAttribute("totalCost", catalog.totalCost());

        return "redirect:payment";
    }
}
