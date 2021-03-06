package com.jinshuai.seckill.account.controller;

import com.jinshuai.seckill.account.entity.User;
import com.jinshuai.seckill.account.service.UserService;
import org.apache.rocketmq.client.impl.consumer.ProcessQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @author: JS
 * @date: 2018/9/19
 * @description: MySQL主从分离
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listUsers() {
        List<User> result = userService.listUsers();
        return result;
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        user.setUsername("靳帅_测试");
        userService.updateUser(user);
    }

}