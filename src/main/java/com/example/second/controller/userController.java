package com.example.second.controller;

import com.example.second.dao.userDao;
import com.example.second.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class userController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private userDao userDao;

    @PostMapping(path = "insertUser")
    public void insertUser(@RequestBody userEntity user){
        this.userDao.insertUser(user.getFirst_name(),user.getLast_name(),user.getEmail(),user.getPassword(),user.getAddress());
    };

    @GetMapping(path = "/getAllUsers")
    public List<userEntity> getAllUsers(){
        return this.userDao.getAllUsers();
    }

    @GetMapping(path = "/getUserById")
    public userEntity getUserById(@RequestParam Integer user_id){
        return this.userDao.getUserById(user_id);
    }

    @PostMapping(path = "resetPassword")
    public void resetPassword(@RequestBody userEntity user){
        this.userDao.resetPassword(user.getPassword(),user.getUser_id());
    }

    @GetMapping(path = "deleteUserById")
    public void deleteUserById(@RequestParam Integer user_id){
        this.userDao.deleteUserById(user_id);
    }


}
