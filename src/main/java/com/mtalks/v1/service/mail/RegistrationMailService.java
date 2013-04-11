package com.mtalks.v1.service.mail;

import org.apache.commons.mail.EmailException;

/**
 * Date: 3/27/13
 * Time: 11:17 AM
 */
public interface RegistrationMailService {

    public void sendConfirmationEmail(String userEmail, String confirmationToken, String serverName) throws EmailException;

    public void sendRemindPasswordEmail(String userEmail, String confirmationToken, String serverName) throws EmailException;
}
