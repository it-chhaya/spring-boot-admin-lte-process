package com.hrdcenter.springbootthymeleaf;

import com.hrdcenter.springbootthymeleaf.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootThymeleafApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        System.out.println("USER = " + userRepository.findByUsername("chhaya"));
    }

}
