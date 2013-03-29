package com.mtalks.v1.service.utils.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Date: 3/27/13
 * Time: 2:32 AM
 */
public class CustomSaltSourceImpl implements SaltSource {
    @Override
    public Object getSalt(UserDetails user) {
        return ((SaltedUser) user).getSalt();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
