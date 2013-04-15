package com.mtalks.v1.web;

import com.mtalks.v1.domain.User;
import com.mtalks.v1.service.rest.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * User: vvasil
 * Date: 4/11/13
 * Time: 7:25 PM
 */
@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public String profilePage(@PathVariable("id") String id, ModelMap model){
        User user =  userService.findById(id);
        model.put("user", user);
        model.put("user-old", null);
        if(user.getBirthday() != null){
            model.put("user-old", Integer.valueOf(new Date().getYear() - user.getBirthday().getYear()));
        }
        return "profile/userprofile";
    }
}
