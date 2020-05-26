package com.mk.Service;

import com.mk.Dao.UserDao;
import com.mk.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    public List<User> getUserById(String id){

        return this.userDao.getUserById(id);
    }

    public String addUser(User user){
        return userDao.addUser(user);
    }
    public String removeUser(String id){
        return this.userDao.removeUser(id);
    }

}
