package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Users;

import com.db.grad.javaapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("/")
    public Users addUsers(@Valid @RequestBody Users users) {
        return usersService.addUsers(users);
    }

    @GetMapping("/{id}")
    public Optional<Users> getUsersById(@PathVariable(value = "id") long id) {
        return usersService.getUsersById(id);
    }

}
