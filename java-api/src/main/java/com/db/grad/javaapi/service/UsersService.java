package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers () {
        return usersRepository.findAll();
    }

    public Users addUsers(Users user) {
        return usersRepository.save(user);
    }

    public Optional<Users> getUsersById(long id) {
        return usersRepository.findById(id);
    }


}
