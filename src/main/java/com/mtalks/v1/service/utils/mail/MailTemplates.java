package com.mtalks.v1.service.utils.mail;

import org.apache.commons.mail.EmailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Date: 3/27/13
 * Time: 12:20 PM
 */
@Component
public class MailTemplates {

    private SimpleMailMessage simpleMailMessage;

    private static final String WELCOME_MESSAGE="\t\t\t\tСПАСИБО ЗА РЕГИСТРАЦИЮ! \n\t\t\t\tДЛЯ АКТИВАЦИИ ВАШЕГО АККАУНТА ПРОЙДИТЕ ПО ССЫЛКЕ <html><a href=\"http://%s/activation?activationToken=%s\"/></html>";
    private static final String CHANGE_PSW_MESSAGE = "\t\t\t\t ДЛЯ ИЗМЕНЕНИЯ ПАРОЛЯ ПРОЙДИТЕ ПО ПО ССЫЛКЕ: <html><a href=\"http://%s/changepasswordchecktoken?changetoken=%s\"</html>";

    public SimpleMailMessage getConfirmationSimpleMessage(String userEmail, String activationToken, String serverName) throws EmailException {
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mtalks-auth@mtalks.com");
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Регистрация успешна");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setText(String.format(WELCOME_MESSAGE, serverName, activationToken));
        return simpleMailMessage;
    }

    public SimpleMailMessage getPasswordChangeRequestSimpleMessage(String basicUserMail, String changePasswordToken, String serverName){
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mtalks-auth@mtalks.com");
        simpleMailMessage.setTo(basicUserMail);
        simpleMailMessage.setSubject("Регистрация успешна");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setText(String.format(CHANGE_PSW_MESSAGE, serverName, changePasswordToken));
        return simpleMailMessage;
    }
}
