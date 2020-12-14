package com.hrdcenter.springbootthymeleaf.service;

import com.hrdcenter.springbootthymeleaf.dto.UserDto;
import com.hrdcenter.springbootthymeleaf.entity.User;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);
    User findByUsername(String username);
    List<UserDto> findAll();

}
