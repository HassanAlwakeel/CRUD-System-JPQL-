package com.example.second.dao;

import com.example.second.entity.userEntity;
import com.example.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userDao {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    public List<userEntity> getAllUsers(){
        return this.userRepository.getAllUsers();
    };
    public userEntity getUserById(Integer user_id){
        return this.userRepository.getUserById(user_id);
    }
    public void resetPassword(String password,Integer user_id){
        this.userRepository.resetPassword(password , user_id);
    }
    public void deleteUserById(Integer user_id){
        this.userRepository.deleteUserById(user_id);
    };
    public void insertUser(String firstName, String lastName, String email, String password, String address) {
        this.userRepository.insertUser(firstName, lastName, email, password, address);
    }

}
