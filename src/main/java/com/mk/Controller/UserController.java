package com.mk.Controller;

import com.mk.Entity.User;
import com.mk.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllUser(ModelMap map){
        List<User> userList = (List<User>) userService.getAllUser();
        map.addAttribute("users",userList);
        return "user";
    }

    @GetMapping("/findUser")
    public String findUser(){
        return "findUser";
    }

    @GetMapping("/id")
    public String getUserById(@RequestParam("userId") String id, Model model){
        id = id.trim();
        if (id.equals("")) return "index";
        try{
            List<User> userList = (List<User>) userService.getUserById(id);
            if (userList.isEmpty()) {
                model.addAttribute("errorMsg","Can not find the user with given id ->"+id);
                return "error";
            }
            else {
                model.addAttribute("users",userList);
                return "user";
            }
        }catch (Exception e){
            model.addAttribute("errorMsg","Failed to retrieve user");
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute @Valid User user, Errors errors, Model model){

        if (errors.hasErrors()){
            if(errors.hasFieldErrors("first_name")) model.addAttribute("first_name_error",errors.getFieldError("first_name").getDefaultMessage());
            if(errors.hasFieldErrors("last_name")) model.addAttribute("last_name_error",errors.getFieldError("last_name").getDefaultMessage());
            if(errors.hasFieldErrors("gender")) model.addAttribute("gender_error",errors.getFieldError("gender").getDefaultMessage());
            if(errors.hasFieldErrors("date_of_birth")) model.addAttribute("dob_error",errors.getFieldError("date_of_birth").getDefaultMessage());
            if(errors.hasFieldErrors("email")) model.addAttribute("email_error",errors.getFieldError("email").getDefaultMessage());
            return "addUser";
        }
        System.out.println(user.toString());
        try{
            String msg = userService.addUser(user);
            model.addAttribute("successMsg",msg);
            return "success";
        }catch (Exception e){
            model.addAttribute("errorMsg","User registration failed.");

            return "error";
        }
    }

    @GetMapping("/remove")
    public String remove(){
        return "removeUser";
    }

    @PostMapping("/removeUser")
    public String removeUser(@RequestParam("userId") String id, Model model){
        id = id.trim();
        if (id.equals("")) return "index";
        try{
            String msg = userService.removeUser(id);
            model.addAttribute("successMsg",msg);
            return "success";
        }catch (Exception e){
            model.addAttribute("errorMsg","User "+id+" doesn't exist.");
            return "error";
        }
    }
}
