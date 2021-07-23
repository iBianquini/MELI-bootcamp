package com.meli.dentinhosmongo.controller;

import com.meli.dentinhosmongo.dto.UserDTO;
import com.meli.dentinhosmongo.entity.User;
import com.meli.dentinhosmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO userDTO) {
        return this.userService.createUser(userDTO);
    }
}
