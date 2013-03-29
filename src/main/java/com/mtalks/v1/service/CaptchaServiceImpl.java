package com.mtalks.v1.service;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: vvasil
 * Date: 3/26/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    ReCaptcha reCaptcha;

    private static final String VALID_MESSAGE = "Captcha is valid";

    @Override
    public String checkAnswer(String challenge, String uresponse, HttpServletRequest request) {
       ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(request.getRemoteAddr(), challenge, uresponse);
       return validateAnswer(reCaptchaResponse);
    }

    private String validateAnswer(ReCaptchaResponse reCaptchaResponse){
        if(reCaptchaResponse.isValid()){
            return VALID_MESSAGE;
        }
        else {
            return reCaptchaResponse.getErrorMessage();
        }
    }
}
