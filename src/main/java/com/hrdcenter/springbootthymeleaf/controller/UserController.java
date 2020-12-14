package com.hrdcenter.springbootthymeleaf.controller;

import com.hrdcenter.springbootthymeleaf.dto.UserDto;
import com.hrdcenter.springbootthymeleaf.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/user/create")
    public String addUser(@ModelAttribute @Valid UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            return "/admin/user/create";
        }

        // invoke save user from user service
        userService.save(userDto);

        return "redirect:/admin/user/view-all";
    }

    @GetMapping("/admin/user/create")
    public String viewAddUserPage(@ModelAttribute UserDto userDto,
                                  ModelMap modelMap) {

        modelMap.addAttribute("user", userDto);

        return "/admin/user/create";
    }

    @GetMapping("/admin/user/view-all")
    public String viewUserPage(ModelMap modelMap, @RequestParam(required = false) String lang,
                               @RequestParam(required = false) String query) {

        List<UserDto> users = userService.findAll();
        modelMap.addAttribute("users", users);

        return "/admin/user/view-all";
    }
}
