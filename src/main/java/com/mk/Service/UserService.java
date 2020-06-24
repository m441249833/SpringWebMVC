package com.mk.Service;

import com.mk.Dao.UserDao;
import com.mk.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
    public String removeUser(String id) throws SQLException {
        return this.userDao.removeUser(id);
    }

}
