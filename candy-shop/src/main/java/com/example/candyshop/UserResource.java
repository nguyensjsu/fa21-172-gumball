package com.example.candyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    //REST API FOR USERS HOPEFULLY MAYBE IDK :(
    @Autowired
    UserRepository userRepo;

    /**
     * @Autowired
     * private RestTemplate restTemplate;
     */

    @RequestMapping("/user")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    /**
     * User user = restTemplate.getForObject("localhost:8082/users" + users.id)
     **/


    @RequestMapping("user/{id}")
    public User getUser(@PathVariable("id") long id){
        User found = userRepo.findById(id);
        if(found != null){
            return found;
        }
        else
            System.out.println("NO USER FOUND WITH ID: " +id);
            return null;
    }

}
