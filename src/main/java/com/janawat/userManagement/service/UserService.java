package com.janawat.userManagement.service;


import com.janawat.userManagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchUserList();
    User updateUser(User user , Long userId);
    void  deleteUser(Long userId);


}
