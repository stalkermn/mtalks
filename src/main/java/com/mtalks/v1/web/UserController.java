package com.mtalks.v1.web;

import com.mtalks.v1.domain.User;
import com.mtalks.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

//    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody User findByName(@RequestParam("email")String email){
//        return userService.findByEmail(email);
//    }
}
