package pseudocode;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private String SMTP_HOST ="smtp.gmail.com";
	private String FROM_ADDRESS ="mittalmail.1@gmail.com";
	private String PASSWORD ="Bunny@007";
	private String FROM_NAME="Amit Mittal";
	
	public boolean sendMail(String[] recepients, String[] bccRecepients, String subject,String message)
	{
		
		try{
			//Amit: Map Class
			Properties props =new Properties();
			props.put("mail.smtp.host",SMTP_HOST );
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "false");
			props.put("mail.smtp.ssl.enable", "true");
			
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(FROM_ADDRESS,PASSWORD);
				}
			});
			
			Message msg = new MimeMessage(session);
			InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
			msg.setFrom(from);	
			//To Recipients
			InternetAddress[] toAddresses = new InternetAddress[recepients.length];
			for (int i =0;i<recepients.length; i++)
			{
				toAddresses[i] = new InternetAddress(recepients[i]);	
			}
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			//BCC Recipients
			InternetAddress[] bccAddresses = new InternetAddress[bccRecepients.length];
			for (int i =0;i<bccRecepients.length; i++)
			{
				bccAddresses[i] = new InternetAddress(bccRecepients[i]);		
			}	
			msg.setRecipients(Message.RecipientType.BCC, bccAddresses);	
			msg.setSubject(subject);
			msg.setContent(message,"text/plain");
			Transport.send(msg);	
			return true;	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
}
