package com.mtalks.v1.service;

import com.mtalks.v1.domain.BasicUser;
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
    public Boolean registration(BasicUser basicUser, HttpServletRequest request) {
        if(basicUser != null && UserValidator.validate(basicUser)){
            basicUser.setEnabled(false);
            basicUser.setRole(2);
            basicUser.setPassword(passwordEncoder.encodePassword(basicUser.getPassword(), basicUser.getEmail()));
            try{
                mailService.sendConfirmationEmail(userService.save(basicUser).getEmail(), confirmService.save(createConfirm(basicUser)).getToken(), String.format(HOST_PORT, request.getServerName(),request.getServerPort()));

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
        BasicUser bu = userService.findByEmail(confirm.getEmail());
        if( null != confirm && null != bu && !bu.isEnabled()){
            bu.setEnabled(true);
            userService.update(bu);
            confirmService.delete(confirm);
            return true;
        } else {
            return false;
        }
    }

    private Confirm createConfirm(BasicUser user){
        Confirm confirm = new Confirm();
        confirm.setCreationTime(new Date());
        confirm.setEmail(user.getEmail());
        confirm.setToken(UUID.randomUUID().toString());
        return confirm;
    }
}
