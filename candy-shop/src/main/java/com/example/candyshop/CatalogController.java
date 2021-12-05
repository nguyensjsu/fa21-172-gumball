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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
	private CatalogCommandRepository catalogRepo;

    @GetMapping
    public String getAction( @ModelAttribute("catalog") Catalog catalog, Model model) {
    	return "catalog" ;
    }
    
    @PostMapping
    public String postAction(@Valid @ModelAttribute("catalog") Catalog catalog, Errors errors, Model model) {
        return "redirect:payment";
    }
}
