package com.mtalks.v1.web;

import com.mtalks.v1.domain.BasicUser;
import com.mtalks.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//@Controller
public class SearchController {

    //@Autowired
    UserService userService;
    //@Autowired
    MessageSource messageSource;

    //@RequestMapping(value = "/searchby", method = RequestMethod.GET)
//    public List<String> searchByLogin(@RequestParam("login") String login, HttpServletResponse response){
//        List<BasicUser> lc = userService.findByLoginEntry(login);
//        List<String> resp = new ArrayList<String>();
//        if(lc.size()>0)
//        {
//            for(BasicUser c : lc){
//                System.out.println(c.toString());
//                resp.add(c.toString());
//            }
//        }
//        else{
//            resp.add("No matches found");
//        }
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
//        return resp;
//    }

    //@RequestMapping(value = "/searchby", method = RequestMethod.GET)
//    public List<String> searchByTelephone(@RequestParam("telephone") String telephone, HttpServletResponse response){
//        List<BasicUser> lc = userService.findByPhoneEntry(telephone);
//        List<String> resp = new ArrayList<String>();
//        if(lc.size()>0)
//        {
//            for(BasicUser c : lc){
//                System.out.println(c.toString());
//                resp.add(c.toString());
//            }
//        }
//        else{
//            resp.add("No matches found");
//        }
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
//        return resp;
//    }
}
