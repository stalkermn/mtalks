package com.mtalks.v1.service;

import com.mtalks.v1.service.utils.mail.MailTemplates;
import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 8:16 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/resources/test-context.xml")
public class MailSenderImplTest {

    @Autowired
    @Qualifier(value = "mailSender")
    private MailSender mailSender;
    @Autowired
    MailTemplates templates;

    SimpleMailMessage simpleMailMessage;

    @Test
    public void testSendConfirmationEmail() throws Exception {
        mailSender.send(createSimpleMessage());
    }

    @Test
    public void testSendRemindPasswordEmail() throws Exception {
        mailSender.send(createSimpleMessage());
    }

    private SimpleMailMessage createSimpleMessage() throws EmailException {
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mtalks-auth@mtalks.com");
        simpleMailMessage.setTo("stalker-mn@mail.ru");
        simpleMailMessage.setSubject("Регистрация успешна\t" );
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setText("Приуууеееттт\t" + UUID.randomUUID().toString());
        return simpleMailMessage;
    }
}
