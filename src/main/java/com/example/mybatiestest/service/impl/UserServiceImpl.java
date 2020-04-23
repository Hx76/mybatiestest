package com.example.mybatiestest.service.impl;

import com.example.mybatiestest.mapper.TbUserMapper;
import com.example.mybatiestest.pojo.TbUser;
import com.example.mybatiestest.pojo.TbUserExample;
import com.example.mybatiestest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;
    @Override
    public void addUser(TbUser user) {
        this.userMapper.insert(user);
    }

    @Override
    public List<TbUser> findUsersAll() {
        TbUserExample example = new TbUserExample();
        return this.userMapper.selectByExample(example);
    }

    @Override
    public TbUser findUserById(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(TbUser users) {
        this.userMapper.updateByPrimaryKey(users);
    }

    @Override
    public void deleteUser(int id) {
        this.userMapper.deleteByPrimaryKey(id);
    }
}
