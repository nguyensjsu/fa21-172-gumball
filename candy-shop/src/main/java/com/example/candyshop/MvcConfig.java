
package com.example.candyshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/welcome").setViewName("welcome");
    registry.addViewController("/catalog").setViewName("catalog");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/register").setViewName("register");
    registry.addViewController("/payment").setViewName("payment");
    registry.addViewController("/admin").setViewName("admin");
    registry.addViewController("/customers").setViewName("customers");
    registry.addViewController("/delete").setViewName("delete");
    registry.addViewController("/clear").setViewName("clear");
    registry.addViewController("/adminRegisterCustomer").setViewName("adminRegisterCustomer");
  }

}