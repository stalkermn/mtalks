package com.mtalks.v1.web;

import com.mtalks.v1.domain.BasicUser;
import com.mtalks.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@Controller
public class ContactController {
//
//	//@Autowired
//	private UserService userService;
//
////    //@RequestMapping(value = "/search/login/{login}")
////    public String searchByLogin(@PathVariable("login") String login, Map<String, Object> map){
////
////        map.put("basicUser", new BasicUser());
////        map.put("searchResult", userService.findByLoginEntry(login));
////        return "searchresult";
////    }
////
////    //@RequestMapping(value = "/search/telephone/{telephone}")
////    public String searchByTelephone(@PathVariable("telephone") String telephone, Map<String, Object> map){
////
////        map.put("basicUser", new BasicUser());
////        map.put("searchResult", userService.findByPhoneEntry(telephone));
////        return "searchresult";
////    }
//
//	//@RequestMapping("/")
//	public String home() {
//		return "redirect:/search";
//	}
//
//    //@RequestMapping(value = "/search", method = RequestMethod.GET)
//    public ModelAndView loginPage(){
//        return new ModelAndView("search");
//    }
//
//    //@RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addContact(@ModelAttribute("contact") BasicUser basicUser,
//                             BindingResult result) {
//
//        userService.save(basicUser);
//
//        return "redirect:/search";
//    }
//	//@RequestMapping("/delete/{contactId}")
//	public String deleteContact(@PathVariable("contactId") String contactId) {
//
//		userService.delete(contactId);
//
//		return "redirect:/search";
//	}
//
//    //@RequestMapping(value = "/search")
//    public String searchForm() {
//        return "search";
//    }
//
//
//
//    //@RequestMapping("/edit")
//    public String edit( @ModelAttribute("contact") BasicUser basicUser,
//            @RequestParam("login") String login,
//            @RequestParam("password") String password,
//            @RequestParam("enabled") boolean enabled,
//            @RequestParam("firstname") String firstname,
//            @RequestParam("lastname") String lastname,
//            @RequestParam("gender") String gender
//            ){
//            basicUser.setLogin(login);
//            basicUser.setPassword(password);
//            basicUser.setEnabled(enabled);
//            basicUser.setFirstname(firstname);
//            basicUser.setLastname(lastname);
//            basicUser.setGender(gender);
//            userService.update(basicUser);
//        return "redirect:/search";
//    }
//
//    //@RequestMapping(value = "/addContact", method = RequestMethod.GET)
//    public String showCreateUser(Model model) {
//       BasicUser basicUser = new BasicUser();
//        basicUser.setEnabled(true);
//        model.addAttribute("contact", basicUser);
//        return "addeditContact";
//    }
//
//    //@RequestMapping(value = "/editContact", method = RequestMethod.GET)
//    public String editContact(@RequestParam("id") String id, Model model) {
//        model.addAttribute("contact", userService.findById(id));
//        return "addeditContact";
//    }
}
