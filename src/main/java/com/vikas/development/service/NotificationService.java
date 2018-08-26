/**
 * 
 */
package com.vikas.development.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vikas.development.model.User;

/**
 * @author vikas
 *
 */
@Service
public class NotificationService {

	@Autowired
	private JavaMailSender mailsender;

	@Value("${spring.mail.username}")
	private String sender;

	private Date date;

	public void sendEmailMessage(User user) throws MailException {

		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setFrom(sender);
		emailMessage.setSentDate(date);
		emailMessage.setTo("vsivarav@uncc.edu");
		emailMessage.setText("Hello Vikas ! Email sent successfully via Spring Boot");
		mailsender.send(emailMessage);

	}

}
