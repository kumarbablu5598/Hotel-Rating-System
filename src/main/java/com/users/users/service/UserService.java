package com.users.users.service;

import com.users.users.model.users;
import com.users.users.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public ResponseEntity<List<users>>getAll(){
        List<users> list = userRepo.findAll();
        return ResponseEntity.of(Optional.of(list));

    }
    public ResponseEntity<users> getUser(int id){
        users ur = userRepo.findById(id).get();
        if(ur!=null)
            return ResponseEntity.of(Optional.of(ur));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    public ResponseEntity<String> addUser(users user ){
        if(user!= null){
            userRepo.save(user);
            return new ResponseEntity<String>("saved user", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Please pass mandatory parameters", HttpStatus.BAD_REQUEST);
        }


    }
    public ResponseEntity<String> deleteUser(int userid) {
        users user =  userRepo.findById(userid).get();
        if(user !=null && userid>=0) {
            userRepo.deleteById(userid);
            return new ResponseEntity<>("User Deleted ", HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("Eneter User Id ", HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    public ResponseEntity<String> updateUser(users user,int userid){
        users newUser = userRepo.findById(userid).get();
        if(user!= null){
            newUser.setUserName(user.getUserName());
            newUser.setAge(user.getAge());
            newUser.setEmailId(user.getEmailId());
            userRepo.save(newUser);
            return new ResponseEntity<>("Updated",HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("Plese enter valid id",HttpStatus.BAD_REQUEST);

    }

}
