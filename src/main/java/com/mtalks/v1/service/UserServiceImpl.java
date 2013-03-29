package com.mtalks.v1.service;

import com.mtalks.v1.dao.UserRepository;
import com.mtalks.v1.domain.BasicUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date: 3/25/13
 * Time: 1:07 PM
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public BasicUser save(BasicUser basicUser) {
        return userRepository.save(basicUser);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BasicUser> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public BasicUser findById(String id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public BasicUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Transactional
    @Override
    public void deleteByLogin(String login) {
        BasicUser bu = new BasicUser();
        bu.setLogin(login);
        userRepository.delete(bu);
    }

    @Transactional(readOnly = true)
    @Override
    public BasicUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public void update(BasicUser basicUser) {
        userRepository.save(basicUser);
    }
}
