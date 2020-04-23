package com.example.mybatiestest.controller;

import com.example.mybatiestest.pojo.TbUser;
import com.example.mybatiestest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    /**
     * 添加用户
     */
    @PostMapping("/addUser")
    public String addUser(TbUser user){
        try {
            service.addUser(user);
        }catch (Exception e){
            return "error";
        }
        return "redirect:/ok";
    }

    /**
     * 查询全部用户
     */
    @GetMapping("/findUserAll")
    public String findUserAll(Model model){
        List<TbUser> list = null;
        try {
            list = this.service.findUsersAll();
            model.addAttribute("list",list);
        }catch (Exception e){
            return "error";
        }
        return "showUsers";
    }

    @GetMapping("/preupdateUser")
    public String preUpdateUser(int id, Model model){
        try{
            TbUser users = this.service.findUserById(id);
            model.addAttribute("user",users);
        }catch (Exception e){
            return "error";
        }
        //防止表单重复提交
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(TbUser users){
        try{
            this.service.updateUser(users);
        }catch (Exception e){
            return "error";
        }
        //防止表单重复提交
        return "redirect:/ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUpdate(int id){
        try{
            this.service.deleteUser(id);
        }catch (Exception e){
            return "error";
        }
        //防止表单重复提交
        return "redirect:/ok";
    }
}
