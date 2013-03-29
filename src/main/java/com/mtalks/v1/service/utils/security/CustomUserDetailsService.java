package com.mtalks.v1.service.utils.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mtalks.v1.dao.UserRepository;
import com.mtalks.v1.domain.BasicUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public SaltedUser loadUserByUsername(String username)
            throws UsernameNotFoundException {
        BasicUser user = getUserDetail(username);
        SaltedUser userDetail = null;
        if(user != null){
            System.out.println(username);
            userDetail = new SaltedUser(user.getLogin(),user.getPassword(),user.isEnabled(),true,true,true,getAuthorities(user.getRole()), user.getEmail());
        }
        else {
            throw new  UsernameNotFoundException("User not found");
        }
        return userDetail;
    }


    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }

    public BasicUser getUserDetail(String username){
        System.out.println(username);
        BasicUser user = userRepository.findByLogin(username);
        if(user ==null){
            user = userRepository.findByEmail(username);
        }
        if(user ==null){
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("THIS USER IS: "+user.toString()+ "::"+ user.getPassword());
        return user;
    }

    public static UserDetails getPrincipal() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((SaltedUser) obj);
    }

    public static String getCredentials(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return (String) obj;
    }

}