package com.mtalks.v1.service.registration;

import com.mtalks.v1.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Date: 3/27/13
 * Time: 11:15 AM
 */
public interface RegistrationService {

    public Boolean registration(User user, HttpServletRequest request);

    public Boolean confirmation(String token);
}
