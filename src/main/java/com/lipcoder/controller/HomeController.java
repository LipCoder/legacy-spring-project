package com.lipcoder.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
       log.info("this is index page!!!");
       model.addAttribute("data", "Hello, Spring form IntelliJ! Good! :)");
       return "index";
    }
}


