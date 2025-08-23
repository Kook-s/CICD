package kr.handscope.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AppController {

    @GetMapping("/home")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/test1")
    public String test1() {
        return "Hello, test";
    }
}
