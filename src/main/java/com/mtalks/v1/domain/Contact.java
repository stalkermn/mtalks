package com.mtalks.v1.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getLastFM() {
        return lastFM;
    }

    public void setLastFM(String lastFM) {
        this.lastFM = lastFM;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<String> getGenrePreferences() {
        return genrePreferences;
    }

    public void setGenrePreferences(Set<String> genrePreferences) {
        this.genrePreferences = genrePreferences;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this.getClass())
                .append(id)
                .append(telephone)
                .append(skype)
                .append(vk)
                .append(twitter)
                .append(lastFM)
                .append(adress)
                .append(biography)
                .append(facebook)
                .append(genrePreferences)
                .build();
    }
}
