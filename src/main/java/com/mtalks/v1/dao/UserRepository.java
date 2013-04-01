package com.mtalks.v1.dao;

import com.mtalks.v1.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: User
 * Date: 25.03.13
 * Time: 2:30
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByLogin(String login);
    User findById(String id);
    User findByEmail(String email);
}
