package com.example.mybatiestest.service;

import com.example.mybatiestest.pojo.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(TbUser user);
    List<TbUser> findUsersAll();
    TbUser findUserById(int id);
    void updateUser(TbUser users);
    void deleteUser(int id);
}
