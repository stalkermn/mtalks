package com.mtalks.v1.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Document(collection="user")
public class User {

	@Id
	private String id;
    private String login;
    @DBRef
    private Contact contact;
    private String password;
    private boolean enabled;
    private Integer role;
	private String firstname;
	private String lastname;
	private String email;
    private String gender;
    private Date birthday;



    public User(String login, String password, boolean b, boolean b1, boolean b2, boolean b3, Collection<GrantedAuthority> authorities) {
    }

    public User(String login, String psw, Boolean enabled, Integer role, String firstname, String lastname, String email, String gender, Date birthday){
        this.login = login;
        this.password = psw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.email = email;
        this.enabled = enabled;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User() {
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login=login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append(login)
                .append(firstname)
                .append(lastname)
                .append(email)
                .append(enabled)
                .append(gender)
                .append(birthday)
                .append(role).build();
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder()
                .append(login)
                .append(firstname)
                .append(lastname)
                .append(email)
                .append(enabled)
                .append(gender)
                .append(role).build();
    }

    @Override
    public boolean equals(Object o){
        User that = (User) o;
        return new EqualsBuilder()
                .append(this.login, that.login)
                .append(this.firstname, that.firstname)
                .append(this.lastname, that.lastname)
                .append(this.password, that.password)
                .append(this.email, that.email)
                .append(this.gender, that.gender)
                .append(this.role, that.role).build();
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

