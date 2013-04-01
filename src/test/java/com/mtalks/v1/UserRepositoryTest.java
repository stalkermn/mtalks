package com.mtalks.v1;

import com.mtalks.v1.dao.UserRepository;
import com.mtalks.v1.domain.User;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;


/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.03.13
 * Time: 3:42
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class UserRepositoryTest {

    static Logger log = Logger.getLogger(UserRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;
    User user;

    @Before
    public void init(){
        user = new User();
        user.setLogin(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString()+"@test.com");
        user.setEnabled(true);
        user.setFirstname(UUID.randomUUID().toString());
        user.setLastname(UUID.randomUUID().toString());
        user.setRole(2);
        user.setPassword(UUID.randomUUID().toString());
        user.setGender("Male");
        user.setBirthday(new Date());
        user = userRepository.save(user);
    }

    //@Test
    public void testFindByLogin() throws Exception {
        log.info("Create and save testUser");
        User user = new User();
        user.setLogin("test");
        user.setEmail("test@test.com");
        user.setEnabled(true);
        user.setFirstname("admin");
        user.setLastname("admin");
        user.setRole(2);
        user.setPassword("test");
        user.setGender("Male");
        user.setBirthday(new Date());
        mongoTemplate.save(user);

        User new_User = userRepository.findByLogin(user.getLogin());
        Assert.assertTrue(new_User != null);
        System.out.println("USER:  " + new_User.toString());
        Assert.assertEquals(user.getFirstname(), new_User.getFirstname());
        System.out.println("PASSWORD:  "+ new_User.getPassword());

    }

    @Test
    public void testFindByEmail(){
        User newUser = userRepository.findByEmail(user.getEmail());
        Assert.assertTrue(newUser.equals(user));
    }

    @Test
    public void testUpdate(){
        System.out.println(user);
        user.setEmail(("sgkjfhglkdfsgfa@rtertr.ree"));
        userRepository.save(user);
        User updatedUser = userRepository.findById(user.getId());
        Assert.assertEquals(user.getId(), updatedUser.getId());
        Assert.assertTrue(user.getEmail().equals(updatedUser.getEmail()));
    }
}
