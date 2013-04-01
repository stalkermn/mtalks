package com.mtalks.v1.dao;

import com.mtalks.v1.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: vvasil
 * Date: 4/1/13
 * Time: 10:39 AM
 */
public interface ContactRepository extends MongoRepository<Contact, String> {
}
