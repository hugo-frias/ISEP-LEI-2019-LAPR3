package lapr.project.data;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class EmailHandler {

    private Properties p;
    private Session s;
    private String username;
    private String password;

    public EmailHandler() {
        p = new Properties(System.getProperties());

        try (InputStream input = new FileInputStream("target/classes/email.properties")) {
            p.load(input);
            System.setProperties(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.username = System.getProperty("mail.username");
        this.password = System.getProperty("mail.password");

        s = Session.getInstance(p, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public boolean sendEmail(String destinationEmail, String subject, String emailBody) {
        try {

            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress(System.getProperty("mail.username")));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationEmail));

            message.setSubject(subject);
            message.setText(emailBody);

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
