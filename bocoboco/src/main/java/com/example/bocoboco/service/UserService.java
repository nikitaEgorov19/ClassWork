package com.example.bocoboco.service;


import com.example.bocoboco.entity.UserEntity;
import com.example.bocoboco.exceptions.UserNotFoundException;
import com.example.bocoboco.model.User;
import com.example.bocoboco.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
 public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getOne(Integer id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользовате5ль не найден");
        }
        return User.toModel(user);
    }

    public Integer delete(Integer id) {
        userRepo.deleteById(id);
        return id;
    }
}
