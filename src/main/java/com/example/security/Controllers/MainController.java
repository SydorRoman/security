package com.example.security.Controllers;

import com.example.security.Service.CustomerService;
import com.example.security.models.Customer;
import com.example.security.utlis.CustomerEditor;
import com.example.security.utlis.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PropertySource("classpath:validation.properties")//ctrl + b
public class MainController {

    @Autowired
    private Environment environment;

    @Autowired
    //@Qualifier("customerServiceImpl")
    private CustomerService customerService;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/ok")
    public String ok(){
        return "success";
    }

    @PostMapping("/login-error")
    public String login_error(){
        return "main";
    }

    @GetMapping("/login")
    public String asd(){
        return "login";
    }


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerEditor customerEditor;
    @Autowired
    private CustomerValidator customerValidator;

    @PostMapping("/save")
    public String save(Customer customer, BindingResult result, Model model) {

        customerValidator.validate(customer,result);

        if (result.hasErrors())
        {
            String errorMessage = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                errorMessage+= " " +  environment.getProperty(allError.getCode().toString());
            }
            model.addAttribute("error",errorMessage);

            return "index";
        }


//        String password = customer.getPassword();
//        String encode = passwordEncoder.encode(password);
//        customer.setPassword(encode);

//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));


        customerEditor.setValue(customer);

        customerService.save(customer);
        return "login";
    }

}
