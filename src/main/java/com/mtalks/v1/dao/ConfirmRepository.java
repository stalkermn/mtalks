package com.mtalks.v1.dao;

import com.mtalks.v1.domain.Confirm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 6:37 PM
 */
public interface ConfirmRepository extends MongoRepository<Confirm, String> {
    @Query("{ token: ?0 }")
    Confirm findByToken(String token);

    Confirm findByEmail(String email);

}
