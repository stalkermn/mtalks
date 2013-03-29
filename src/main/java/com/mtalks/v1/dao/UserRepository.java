package com.mtalks.v1.dao;

import com.mtalks.v1.domain.BasicUser;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * User: User
 * Date: 25.03.13
 * Time: 2:30
 */
public interface UserRepository extends MongoRepository<BasicUser, String> {

    BasicUser findByLogin(String login);
    BasicUser findById(String id);
    BasicUser findByEmail(String email);
}
