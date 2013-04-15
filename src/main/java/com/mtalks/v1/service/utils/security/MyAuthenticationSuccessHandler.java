package com.mtalks.v1.service.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public static final String SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
    private static final String REDIRECT_URL = "/id%s";

    /**
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */

    @Autowired
    CurrentUser currentUser;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        setDefaultTargetUrl(String.format(REDIRECT_URL, currentUser.getId()));
        setAlwaysUseDefaultTargetUrl(true);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
