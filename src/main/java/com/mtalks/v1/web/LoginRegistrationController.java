package com.mtalks.v1.web;

import com.mtalks.v1.domain.User;
import com.mtalks.v1.service.registration.RegistrationService;
import com.mtalks.v1.service.registration.CaptchaService;
import com.mtalks.v1.service.rest.UserService;
import com.mtalks.v1.service.utils.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Date: 3/25/13
 * Time: 1:48 PM
 */
@Controller
public class LoginRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    @Qualifier("com.mtalks.v1.service.utils.security.CurrentUser")
    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private RegistrationService registrationService;


    private int authFailedCount;
    private String remoteAdress;

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model, HttpServletRequest request) {
        String aciveCaptcha = null;
        if(request.getRemoteAddr().equals(remoteAdress)){
            model.addAttribute("error", "true");
        }
        //TOD: Add logic for captcha active;
        remoteAdress = request.getRemoteAddr();
        return "registration/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model, HttpServletRequest request) {
         return "registration/login";
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "registration/index";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String login(ModelMap model, @RequestParam(value = "regerror", required = false) Boolean regError) {
        try{
            return "redirect:/id".concat(currentUser.getId());
        }
        catch (NullPointerException e){
            System.out.println("User have no auth");
        }
        finally {
            model.addAttribute("user", new User());
            if(regError!= null && regError){
                model.put("regerror", regError);
            }
            else {
                model.put("regerror", null);
            }
            return "registration/index";
        }




    }

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public ModelAndView search(ModelMap model) {
        return new ModelAndView("search");
    }

//    @RequestMapping(value="/captcha", method = RequestMethod.POST)
//    public ModelAndView captcha(@RequestParam(value = "chalenge", required = true) String challenge,@RequestParam(value = "response", required = true) String response, HttpServletRequest request) {
//        String message = captchaService.checkAnswer(challenge, response, request);
//        return new ModelAndView("search");
//    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user,
                             BindingResult result, HttpServletRequest request, ModelMap modelMap) {
        if(registrationService.registration(user, request)){
            return "registration/registrationSuccess";
        } else {
            return "redirect:/regerror?=true";
        }
    }

    @RequestMapping(value = "/registration/activation", method = RequestMethod.GET)
    public String registerConfirmation(@RequestParam(value = "activationToken", required = true) String token){
        if(registrationService.confirmation(token)){
            return "redirect:/login";
        }
        else{
            //TODO add unsuccess activation message
            return "redirect:/";
        }
    }
    /**
     * json return to view example. Will need for exchange back end with front end
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public  List<User> getAllUsers(){
        return userService.findAll();
    }
}
