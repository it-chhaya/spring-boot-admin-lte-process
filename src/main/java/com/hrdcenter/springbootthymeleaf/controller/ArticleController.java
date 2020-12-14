package com.hrdcenter.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @GetMapping("/view-all")
    public String viewAllPage() {
        return "/admin/article/view-all";
    }

    @GetMapping("/create")
    public String viewCreatePage() {
        return "/admin/article/create";
    }

}
