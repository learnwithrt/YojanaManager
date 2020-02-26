package com.yojana.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yojana.entities.User;


public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true,value = "{call Login_User(:username,:pass)}")  // call store procedure 
    int loginUser(@Param("username")String username,@Param("pass")String pass);
}
