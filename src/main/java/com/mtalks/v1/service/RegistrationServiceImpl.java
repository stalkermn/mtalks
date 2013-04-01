package com.mtalks.v1.service;

import com.mtalks.v1.domain.User;
import com.mtalks.v1.domain.Confirm;
import com.mtalks.v1.service.utils.security.UserValidator;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 6:31 PM
 */
@Transactional
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MailService mailService;
    @Autowired
    ConfirmService confirmService;

    private static final String HOST_PORT = "%s:%d";

    @Transactional
    @Override
    public Boolean registration(User user, HttpServletRequest request) {
        if(user != null && UserValidator.validate(user)){
            user.setEnabled(false);
            user.setRole(2);
            user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getEmail()));
            try{
                mailService.sendConfirmationEmail(userService.save(user).getEmail(), confirmService.save(createConfirm(user)).getToken(), String.format(HOST_PORT, request.getServerName(),request.getServerPort()));

            } catch (EmailException ex){
                System.out.println(ex.getMessage());
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional
    @Override
    public Boolean confirmation(String token) {
        Confirm confirm = confirmService.findByToken(token);
        User user = userService.findByEmail(confirm.getEmail());
        if( null != confirm && null != user && !user.isEnabled()){
            user.setEnabled(true);
            userService.update(user);
            confirmService.delete(confirm);
            return true;
        } else {
            return false;
        }
    }

    private Confirm createConfirm(User user){
        Confirm confirm = new Confirm();
        confirm.setCreationTime(new Date());
        confirm.setEmail(user.getEmail());
        confirm.setToken(UUID.randomUUID().toString());
        return confirm;
    }
}
