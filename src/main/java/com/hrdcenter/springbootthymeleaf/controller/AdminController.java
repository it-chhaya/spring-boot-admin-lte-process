package com.hrdcenter.springbootthymeleaf.controller;

import com.hrdcenter.springbootthymeleaf.annotations.IsAdmin;
import com.hrdcenter.springbootthymeleaf.annotations.IsEditor;
import com.hrdcenter.springbootthymeleaf.annotations.IsUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String viewAdminPage() {
        return "/admin/dashboard";
    }

    @GetMapping("/admin")
    public String viewHomePage() {
        return "/admin/index";
    }

}
