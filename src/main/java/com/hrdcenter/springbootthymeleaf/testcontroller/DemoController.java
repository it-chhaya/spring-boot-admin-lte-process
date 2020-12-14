package com.hrdcenter.springbootthymeleaf.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("raw-html")
    public String renderHtmlCode(ModelMap modelMap) {

        modelMap.addAttribute("isChecked", false);
        modelMap.addAttribute("gender", "F");

        return "raw-html";
    }

}
