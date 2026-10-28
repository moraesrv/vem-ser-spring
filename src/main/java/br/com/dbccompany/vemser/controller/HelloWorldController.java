package br.com.dbccompany.vemser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    
    @GetMapping
    public String helloworld() {
        return "HelloWorld!";
    }

}
