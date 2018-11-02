package com.example.security.Dao;

import com.example.security.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface  CustomerDao extends JpaRepository<Customer,Integer> {

//    @Query("SELECT c from Customer c where c.username=:username")
//    Customer asd(@Param("username") String username);

    Customer findByUsername(String username);

//    Customer deleteByAccountNonExpired(String accountNonExpired);




}
