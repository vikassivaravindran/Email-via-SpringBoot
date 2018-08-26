/**
 * 
 */
package com.vikas.development.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.development.model.User;

/**
 * @author vikas
 *
 */
@RestController
@RequestMapping("/api")
public class ControllerService {

	@Autowired
	public NotificationService service;

	private static final Logger logger = Logger.getLogger(ControllerService.class);

	@GetMapping("/signup")
	public String newUserSignUp() {

		User user = new User("Vikas", "Sivaravindran", "your_gmail_id");

		try {
			service.sendEmailMessage(user);
		} catch (Exception e) {
			logger.error(e);
		}
		return "Congarts ! You have signed up, Please check your email";
	}

}
