package com.mtalks.v1.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 12:10 PM
 */
@Document(collection="confirm")
public class Confirm {

    @Id
    private String id;
    private String token;
    private String email;
    private Date creationTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
