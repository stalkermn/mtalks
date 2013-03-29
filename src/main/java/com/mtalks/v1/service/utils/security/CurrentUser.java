package com.mtalks.v1.service.utils.security;

import com.mtalks.v1.domain.BasicUser;
import com.mtalks.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Date: 3/26/13
 * Time: 8:10 PM
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUser implements Serializable {

    private static final long serialVersionUID = 3511185364019240683L;
    private String id;
    private String login;
    private BasicUser user;
    @Autowired
    private UserService userService;

    private void populateData() {
        try {
            SaltedUser saltedUser = (SaltedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = saltedUser.getUsername();
            user = userService.findByLogin(login);
            id = user.getId();
        } catch (ClassCastException ex) {
            //ignore
        }
    }

    public String getId() {
        if (id == null) {
            populateData();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        if (login == null) {
            populateData();
        }
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BasicUser getUser() {
        if (user == null) {
            populateData();
        }
        return user;
    }

    public void setUser(BasicUser user) {
        this.user = user;
    }
}
