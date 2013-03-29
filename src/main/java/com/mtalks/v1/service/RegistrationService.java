package com.mtalks.v1.service;

import com.mtalks.v1.domain.BasicUser;
import javax.servlet.http.HttpServletRequest;

/**
 * Date: 3/27/13
 * Time: 11:15 AM
 */
public interface RegistrationService {

    public Boolean registration(BasicUser basicUser, HttpServletRequest request);

    public Boolean confirmation(String token);
}
