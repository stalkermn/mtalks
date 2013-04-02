package com.mtalks.v1.service;

import com.mtalks.v1.service.utils.mail.MailTemplates;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

/**
 * User: vvasil
 * Date: 3/27/13
 * Time: 3:43 PM
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendConfirmationEmail(String userEmail, String confirmationToken, String serverName) throws EmailException {
        mailSender.send(MailTemplates.getConfirmationSimpleMessage(userEmail, confirmationToken, serverName));
    }

    @Override
    public void sendRemindPasswordEmail(String userEmail, String confirmationToken, String serverName) throws EmailException {
        mailSender.send(MailTemplates.getPasswordChangeRequestSimpleMessage(userEmail, confirmationToken, serverName));
    }
}
