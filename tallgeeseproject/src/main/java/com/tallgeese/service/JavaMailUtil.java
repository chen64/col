package com.tallgeese.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallgeese.model.User;
import com.tallgeese.repository.UserDao;


@Service("javamail")
public class JavaMailUtil {
	
	static UserDao userDao = new UserDao();
	    
	    
	@Autowired
	public JavaMailUtil(UserDao userDao) {
	    super();
	    JavaMailUtil.userDao = userDao;
	}
	    
	public static void findEmail(String email) throws Exception {
		User recov = userDao.selectByEmail(email);
        if (recov == null) {
            	System.out.println("No User located");
            	return;
        }
        System.out.println("Located user " + recov.getUsername() + " sending mail to their account");
        sendMail(recov);
	}
	
	
	public static void sendMail(User recovery) throws Exception {
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail = "tallgeesegacha@gmail.com";
		String password = "tallgeese6969";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		
		Message message = prepareMessage(session, myAccountEmail, recovery);
		
		Transport.send(message);
		System.out.println("Message sent");
	}
			
		private static  Message prepareMessage(Session session, String myAccountEmail, User recipient) {
			try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail()));
			message.setSubject("Password Recovery");
			message.setText("Greetings " + recipient.getUsername() + ".\nHere is your current password: " + recipient.getPassword() + ".\nWe hope"
					+ "this solves your lost username/password issues.");
			return message;
			} catch (Exception ex) {
				//Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();

			}
			return null;
		}
		
	
	}

