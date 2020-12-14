package com.hrdcenter.springbootthymeleaf.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxController {
    @GetMapping("/ajax/content1")
    public String fragmentContent1(Model model) {
        model.addAttribute("test", "hello");
        return "/test/content :: content1";
    }
    @GetMapping("/ajax/content2")
    public String fragmentContent2() {
        return "/test/content :: content2";
    }
    @GetMapping("/testContent")
    public String testContent() {
        return "/test/test_content";
    }
}
