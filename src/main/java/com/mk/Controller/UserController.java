package com.mk.Controller;

import com.mk.Entity.User;
import com.mk.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public String getAllUser(ModelMap map){
        List<User> userList = (List<User>) userService.getAllUser();
        map.addAttribute("users",userList);
        return "user";
    }
    @RequestMapping("/findUser")
    public String findUser(){
        return "findUser.html";
    }


    @RequestMapping("/id")
    public Object getUserById(@RequestParam("userId") String id, ModelMap map){
        id = id.trim();
        if (id.equals("")) return "index";
        try{
            List<User> userList = (List<User>) userService.getUserById(id);
            if (userList.isEmpty()) return "errorId";
            else {
                map.addAttribute("users",userList);
                return "user";
            }
        }catch (Exception e){
            return "error";
        }
    }

    @RequestMapping("/register")
    public String register(){
        return "addUser";
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestParam("first_name") String fname,
                          @RequestParam("last_name") String lname,
                          @RequestParam("gender") String gender,
                          @RequestParam("year") String year,
                          @RequestParam("month") String month,
                          @RequestParam("day") String day,
                          @RequestParam("email") String email,
                          Model model){
        String dob = year+"-"+month+"-"+day;
        User user = new User(fname,lname,gender,dob,email);
        System.out.println(user.toString());
        try{
            userService.addUser(user);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @RequestMapping("/remove")
    public String remove(){
        return "removeUser";
    }

    @RequestMapping("/removeUser")
    public String removeUser(@RequestParam("userId") String id, Model map){
        id = id.trim();
        if (id.equals("")) return "index";
        try{
            userService.removeUser(id);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }



}
