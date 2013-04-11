package com.mtalks.v1.service.rest;

import com.mtalks.v1.domain.User;

import java.util.List;

public interface UserService {

	public User save(User user);

	public List<User> findAll();

    public User findById(String id);

    public User findByLogin(String Login);

	public void delete(String id);

    public void deleteByLogin(String login);

    public User findByEmail(String email);

    public void update(User user);

    public User findByLoginAndEmail(String login, String email);
}
