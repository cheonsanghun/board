package com.example.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    /*@GetMapping("/sb")
    @ResponseBody
    public String sbb() {
        return "Hello World";
    }
*/
    @GetMapping("/")//기본 루트를 바로 퀘스천 리스트 루트로 지정
    public String root(){
        return "redirect:/question/list";
    }
}
