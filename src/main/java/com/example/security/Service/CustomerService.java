package com.example.security.Service;

import com.example.security.models.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;



public interface CustomerService extends UserDetailsService {


    void save (Customer customer);

}
