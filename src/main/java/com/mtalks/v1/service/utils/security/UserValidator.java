package com.mtalks.v1.service.utils.security;

import com.mtalks.v1.domain.BasicUser;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Date: 3/26/13
 * Time: 6:20 PM
 */
public class UserValidator {

    private static Pattern pattern;

    private static final String LOGIN_AND_NAME_PATTERN = "^[a-zA-Z0-9_-]{3,30}$";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean emailValidation(final String email){
        pattern = Pattern.compile(EMAIL_PATTERN);

        return pattern.matcher(email).matches();
    }

    public static boolean loginValidation(final String login){
        pattern = Pattern.compile(LOGIN_AND_NAME_PATTERN);
        return pattern.matcher(login).matches();
    }
    public static boolean birthdayValidation(Date birthday){
        return (birthday.getTime() != new Date().getTime() && birthday.getYear() > 1900);
    }

    public static Boolean validate(BasicUser basicUser){
        basicUser.getEmail().trim();
        basicUser.getFirstname().trim();
        basicUser.getLastname().trim();
        basicUser.getLogin().trim();
        return (loginValidation(basicUser.getLogin()) && emailValidation(basicUser.getEmail()));
    }
}
