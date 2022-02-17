package com.janawat.userManagement.controller;

import com.janawat.userManagement.model.User;
import com.janawat.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList(){
        return userService.fetchUserList();
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") long userId)
    {
        return userService.updateUser(user,userId);
    }

    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return "Delete Successfully";
    }
}
