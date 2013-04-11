package com.mtalks.v1.web.rest;

import com.mtalks.v1.domain.User;
import com.mtalks.v1.service.rest.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody User findByLogin(@RequestParam("login")String login, @RequestParam(value = "email", required = false) String email){
        if(email == null){
            return userService.findByLogin(login);
        }
        else {
            return userService.findByEmail(email);
        }
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> findAll(){
        return userService.findAll();
    }
}
