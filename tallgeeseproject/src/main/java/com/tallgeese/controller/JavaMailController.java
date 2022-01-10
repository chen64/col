package com.tallgeese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tallgeese.model.User;
import com.tallgeese.service.JavaMailUtil;

@Controller
@RequestMapping("/mailcontroller")
public class JavaMailController {
    
    JavaMailUtil recovery;
        
    public JavaMailController() {
    }
    
    @Autowired
    public JavaMailController(JavaMailUtil recovery) {
        super();
        this.recovery = recovery;
    }
    
    @PostMapping("/recover.app")
    public @ResponseBody void forgot(@RequestParam("user") User user) throws Exception {
        System.out.println("in JavaMailController " + user.toString());
        
        recovery.sendMail(user);
        
    }
}
    
