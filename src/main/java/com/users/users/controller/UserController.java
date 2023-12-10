package com.users.users.controller;

import com.users.users.model.users;
import com.users.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;
    public ResponseEntity<List<users>> getAllUsers(){
        return userservice.getAll();
    }
    // get User by Id
    @GetMapping("/getbyId/{Id}")
    public ResponseEntity<users> getuserById(@PathVariable int Id){
        return userservice.getUser(Id);
    }
    // add users
    @PostMapping("/addUser")
    public ResponseEntity<String> addUsers(@RequestBody users user){
        return userservice.addUser(user);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable int Id){
        return userservice.deleteUser(Id);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<String> updateUser(@RequestBody users user, @PathVariable int Id){
        return userservice.updateUser(user,Id);
    }

}
