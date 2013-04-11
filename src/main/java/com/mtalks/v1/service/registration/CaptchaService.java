package com.mtalks.v1.service.registration;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: vvasil
 * Date: 3/26/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CaptchaService {

    public String checkAnswer(String chalenge, String response, HttpServletRequest request);
}
