package pack;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.websocket.Session;
import javax.mail.Authenticator;

public class SendEmail
{
	/*public static void main(String[] args) {

		Properties prop= System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.user","vikesh.ls11@gmail.com");
		prop.put("mail.smtp.password", "Vikesh@91");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtpp.auth","true");
		
		
		Session session=Session.getInstance(prop,null);
		MimeMessage mime=new MimeMessage(session);
		try
		{
			InternetAddress to=new InternetAddress("vikeshpadarthi@gmail.com");
			InternetAddress from=new InternetAddress("vikesh.ls11@gmail.com");
			
			mime.addRecipient(Message.RecipientType.TO, to);
			mime.setFrom(from);
			mime.setSubject("Java Mail");
			mime.setText("Please work for me");
			
			Transport t=session.getTransport();
			t.connect("smtp.gmail.com","vikesh.ls11@gmail.com","Vikesh@91");
			t.sendMessage(mime,mime.getAllRecipients());
			t.close();
			
			System.out.println("Mail sent sucessfully");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}*/
	 private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	    private static final String SMTP_AUTH_USER = "vikesh.ls11@gmail.com";
	    private static final String SMTP_AUTH_PWD  = "Vikesh@91";
	    
	    public static void main( String[] args )
	    {
	 	//clientWindow cw=new clientWindow();
	   	Properties props = System.getProperties();
	   	System.out.println("Started");
	   	props.put("mail.smtp.host", SMTP_HOST_NAME);
	   	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	   	props.put("mail.smtp.auth", "true");
	   	  props.put("mail.smtp.user", SMTP_AUTH_USER);
	   	    props.put("mail.smtp.password", SMTP_AUTH_PWD);
	props.put("mail.smtp.port", "465");
	props.put("mail.smtp.starttls.enable", "true");


	Session session = Session.getDefaultInstance(props,
	new javax.mail.Authenticator()
	{
		protected PasswordAuthentication getPasswordAuthentication()
		{ return new PasswordAuthentication(SMTP_AUTH_USER,SMTP_AUTH_PWD);	}
	});

	   	try {

	           Message message = new MimeMessage(session);
	           //textField_1
	           message.setFrom(new InternetAddress("vikesh.ls11@gmail.com"));
	          // message.setFrom(new InternetAddress(textField_1.getText()));
	    //textField_2
	    //message.setRecipients(Message.RecipientType.TO,
	                       //InternetAddress.parse(textField_2.getText()));
	           message.setRecipients(Message.RecipientType.TO,
	                               InternetAddress.parse("vikesh.ls11@gmail.com"));
	    //textField_3
	    message.setSubject("sdkjfb");
	    //textArea
	    message.setText("Mail recieved from java application bult by "+ SMTP_AUTH_USER);

	    Transport.send(message);

	    System.out.println("YIPPEEEE..!!!");

	   	} catch (MessagingException e) {
	   	    throw new RuntimeException(e);
	   	}

	    	

	    }
}