package br.com.alugometro.email;

import java.util.Properties;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AlugometroEmailSender {

	private static final String SMTP_HOST = "smtp.gmail.com";
	
	private static final String SMTP_PORT = "465";

	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public void sendSSLMessage(String destinatario, String assunto,
		String mensagem) throws MessagingException {

		Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "alugometrocwi@gmail.com");
        mailProps.put("mail.smtp.host", "smtp.gmail.com");
        mailProps.put("mail.smtp.port", 587);
        mailProps.put("mail.smtp.auth", true);
        mailProps.put("mail.smtp.socketFactory.port", 587);
        mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailProps.put("mail.smtp.socketFactory.fallback", false);
        mailProps.put("mail.smtp.starttls.enable", true);
		
		
		Session session = Session.getDefaultInstance(mailProps,  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("alugometrocwi@gmail.com", "cwicrescer20152");
			}
		});
		
		Message msg = new MimeMessage(session);
		
		InternetAddress addressFrom = new InternetAddress();
		msg.setFrom(addressFrom);
		
		InternetAddress addressTo = new InternetAddress();
		addressTo = new InternetAddress(destinatario);

		msg.setRecipient(Message.RecipientType.TO, addressTo);
		
		msg.setSubject(assunto);
		msg.setContent(mensagem, "text/html; charset=\"UTF-8\"");
		
		Transport transport = session.getTransport("smtps");
		transport.send(msg);
	}
}

//
//
//
//
//package br.com.mail.javamail;
//
//import java.security.Security;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//	
//	public static void main(String args[]) throws Exception {
//		
//		SendMailUsingJavaMail javaMail = new SendMailUsingJavaMail();
//		String[] recipients = {"email@destino"};
//		String subject = "Assunto";
//		String message = "Corpo do E-mail";
//			
//		try {
//			javaMail.sendSSLMessage(recipients, subject, message);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		
//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//		System.out.println("Email enviado com sucesso para os destinatarios!");
//	
//	}
//}
