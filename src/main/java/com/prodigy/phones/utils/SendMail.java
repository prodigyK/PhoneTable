package com.prodigy.phones.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SendMail {

    private static final Logger log = LoggerFactory.getLogger(SendMail.class);

    public static boolean send(String text) {

        Properties emailData = new Properties();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("email.properties");
            emailData.load(inputStream);

        } catch (IOException e){
            log.error("Error occured while loading properties: " + e.getMessage());
            return false;
        }

        final String username = emailData.getProperty("email.username");
        final String password = emailData.getProperty("email.password");
        final String recipient = emailData.getProperty("email.recipient");
        final String url = emailData.getProperty("email.url");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Feedback from: " + url);
            message.setText(text);
            message.setHeader("Content-Type", "text/html; charset=UTF-8");
            message.setHeader("Content-Transfer-Encoding", "base64");
            message.setContent(text, "text/plain; charset=UTF-8");

            log.info("Mail is sent: {}", text);

            Transport.send(message);


        } catch (MessagingException e) {
            log.error("MessagingException: {}", e.getMessage());
            for (StackTraceElement stack : e.getStackTrace()) {
                log.error(stack.toString());
            }
            return false;
        }
        return true;
    }
}
