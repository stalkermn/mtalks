package com.mtalks.v1.service;

import com.mtalks.v1.domain.BasicUser;

import java.util.List;

public interface UserService {

	public BasicUser save(BasicUser basicUser);

	public List<BasicUser> findAll();

    public BasicUser findById(String id);

    public BasicUser findByLogin(String Login);

	public void delete(String id);

    public void deleteByLogin(String login);

    public BasicUser findByEmail(String email);

    public void update(BasicUser basicUser);
}
