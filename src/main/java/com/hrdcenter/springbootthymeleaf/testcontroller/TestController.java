package com.hrdcenter.springbootthymeleaf.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {



    @GetMapping("/test")
    public String viewTestPage(ModelMap modelMap) {

        modelMap.addAttribute("username", "Chan Chhaya");
        modelMap.addAttribute("text", "it.chhaya@gmail.com");
        modelMap.addAttribute("number", "1000");
        modelMap.addAttribute("answer", true);
        modelMap.addAttribute("answerId", 12020);
        modelMap.addAttribute("answerText", "Cambodia");
        modelMap.addAttribute("gender", "M");

        return "/test/test";
    }

}
