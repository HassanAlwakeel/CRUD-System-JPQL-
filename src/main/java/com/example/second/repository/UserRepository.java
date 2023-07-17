package com.example.second.repository;
import com.example.second.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public interface UserRepository extends JpaRepository<userEntity,Integer> {
    @Query(value = "select t from userEntity t")
    List<userEntity> getAllUsers();

    @Query(value = "select t from userEntity t where t.user_id =:id")
    userEntity getUserById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "update userEntity t set t.password=:password where t.user_id=:user_id")
    void resetPassword(String password,Integer user_id);
    @Modifying
    @Transactional
    @Query(value = "delete from userEntity t where t.user_id=:user_id")
    void deleteUserById(Integer user_id);

    @Modifying
    @Transactional
    @Query("insert into userEntity(first_name, last_name, email, password, address) " +
            "values (:first_name, :last_name, :email, :password, :address)")
    void insertUser(String first_name, String last_name, String email, String password, String address);


}

