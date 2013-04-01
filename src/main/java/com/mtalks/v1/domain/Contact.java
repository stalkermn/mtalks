package com.mtalks.v1.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Set;

/**
 * User: User
 * Date: 24.03.13
 * Time: 12:33
 */
@Document(collection = "contact")
public class Contact {
    private String id;
    private String telephone;
    private String skype;
    private String facebook;
    private String twitter;
    private String vk;
    private String lastFM;
    private String biography;
    private Set<String> genrePreferences;
    private String adress;
}
