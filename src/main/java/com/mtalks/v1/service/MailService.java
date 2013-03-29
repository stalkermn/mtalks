package com.mtalks.v1.service;

import com.mtalks.v1.domain.BasicUser;
import org.apache.commons.mail.EmailException;

/**
 * Date: 3/27/13
 * Time: 11:17 AM
 */
public interface MailService {

    public void sendConfirmationEmail(String userEmail, String confirmationToken, String serverName) throws EmailException;

    public void sendRemindPasswordEmail(String userEmail, String confirmationToken, String serverName) throws EmailException;
}
