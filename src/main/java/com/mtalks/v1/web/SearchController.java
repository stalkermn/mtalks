package com.mtalks.v1.web;

import com.mtalks.v1.service.UserService;
import org.springframework.context.MessageSource;

//@Controller
public class SearchController {

    //@Autowired
    UserService userService;
    //@Autowired
    MessageSource messageSource;

    //@RequestMapping(value = "/searchby", method = RequestMethod.GET)
//    public List<String> searchByLogin(@RequestParam("login") String login, HttpServletResponse response){
//        List<User> lc = userService.findByLoginEntry(login);
//        List<String> resp = new ArrayList<String>();
//        if(lc.size()>0)
//        {
//            for(User c : lc){
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
//        List<User> lc = userService.findByPhoneEntry(telephone);
//        List<String> resp = new ArrayList<String>();
//        if(lc.size()>0)
//        {
//            for(User c : lc){
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
