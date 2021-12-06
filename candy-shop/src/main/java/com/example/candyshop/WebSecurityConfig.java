
package com.example.candyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  // AUTHENTICATION
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.jdbcAuthentication();
    auth.userDetailsService(userDetailsService);
  }

  // AUTHORIZATION
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/backoffice").hasRole("ADMIN")
        .antMatchers("/main").hasRole("ADMIN")
        .antMatchers("/clear").hasRole("ADMIN")
        .antMatchers("/main/delete").hasRole("ADMIN")
        .antMatchers("/main/clear").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
        .antMatchers("/", "/css/**", "/images/**", "/homepage", "/register", "/adminRegisterCustomer")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/catalog")
        .and()
        .logout()
        .logoutSuccessUrl("/");
    /**
     * NOTE MIGHT NEED TO CHANGE ABOVE CODE FORM .hasRole to .hasAuthority
     * .formLogin()
     * .loginPage("/login")
     * .permitAll()
     * .failureUrl("/login?error=true")
     * .defaultSuccessUrl("/welcome")
     * .and()
     * .logout()
     * .logoutSuccessUrl("/homepage");
     **/

    // .antMatchers("/ADMIN PAGES").hasRole("ADMIN")
    // .antMatchers(|/USER PAGES|).hasAnyRole("User","ADMIN")
    // .antMatchers("/","/csss/**").permitAll() ....

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers("/h2-console/**");
  }

  @Bean
  public InMemoryUserDetailsManager getInMemUserDetMan() {
    return new InMemoryUserDetailsManager();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}
