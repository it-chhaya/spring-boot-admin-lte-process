package com.hrdcenter.springbootthymeleaf.service.impl;

import com.hrdcenter.springbootthymeleaf.dto.UserDto;
import com.hrdcenter.springbootthymeleaf.entity.Role;
import com.hrdcenter.springbootthymeleaf.entity.User;
import com.hrdcenter.springbootthymeleaf.repository.RoleRepository;
import com.hrdcenter.springbootthymeleaf.repository.UserRepository;
import com.hrdcenter.springbootthymeleaf.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    Role createRoleIfNotFound(Role newRole) {
        Role role = roleRepository.findByName(newRole.getName());
        if (role == null) {
            role = roleRepository.save(newRole);
        }
        return role;
    }

    @Override
    public User save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role admin = new Role("ROLE_GENERAL");

        Role role = createRoleIfNotFound(admin);

        user.getRoles().add(role);

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username and password!");
        }
        return user;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

}
