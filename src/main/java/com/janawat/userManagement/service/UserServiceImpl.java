package com.janawat.userManagement.service;

import com.janawat.userManagement.model.User;
import com.janawat.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDb = userRepository.findById(userId).get();

        if(Objects.nonNull(user.getFirstName())
                && !"".equalsIgnoreCase(user.getFirstName())){

            user.setFirstName(user.getFirstName());
        }

        if(Objects.nonNull(user.getLastName())
                && !"".equalsIgnoreCase(user.getLastName())){
            userDb.setLastName(user.getLastName());
        }


        return userRepository.save(userDb);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
