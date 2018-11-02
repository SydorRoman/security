package com.example.security.Service.ServiceImpl;

import com.example.security.Dao.CustomerDao;
import com.example.security.Service.CustomerService;
import com.example.security.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }


    //навіщо його тут укати якшо можна викликати через метод в ДАО
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerDao.findByUsername(username);
    }


}