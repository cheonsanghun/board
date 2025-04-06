package com.example.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/ssb")
    @ResponseBody
    public String sbb() {
        return "Hello World";
    }
}
