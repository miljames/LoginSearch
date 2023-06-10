package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.query.LoginQuery;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin
public class LoginController implements Serializable {

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean login(@RequestBody User user) {
      //  System.out.println(user.getUsername());
      // System.out.println(user.getPassword());
        if (user.getPassword() == null || user.getUsername() == null) {
            return false;
        }
        List<User> registeredUsers = getRegisteredUsers();
        return registeredUsers.contains(user);
    }

    private List<User> getRegisteredUsers() {
        List<User> registeredUsers = new ArrayList<User>() {
            {
                add(new User("jenny", "wowzam"));
                add(new User("tommygun", "powpow"));
                add(new User("jones", "guess"));
            }
        };
        return registeredUsers;
    }
//    private boolean credsMatch(User user, LoginQuery creds) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//
//        if(creds != null) {
//            return true;
//        }
//    }
}