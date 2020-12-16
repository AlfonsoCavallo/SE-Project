package se.project.business_logic.utilities;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static se.project.business_logic.utilities.FileUtilities.getStringFromFile;
import se.project.business_logic.utilities.interfaces.MailSenderInterface;
import se.project.storage.models.Maintainer;
import se.project.storage.models.maintenance_activity.MaintenanceActivity;

/**
 * Provides utility static methods for notify and mail sending.
 * 
 */
public class MailSender implements MailSenderInterface
{
    private final String MAIL_TEXT_PATH = "/se/project/assets/files/MailText.txt";
    private final String SENDER_MAIL = "gruppo8se@gmail.com";
    private final String SENDER_PASSWORD = "equilocianc";
    private final MaintenanceActivity maintenanceActivity;
    private final String day;
    private final String time;

    /**
     * Instantial a MailSender object.
     * @param maintenanceActivity is the Maintenance Activity.
     * @param day is the day of the Maintenance Activity.
     * @param time is the time of the Maintenance Activity.
     */
    public MailSender(MaintenanceActivity maintenanceActivity, String day, String time)
    {
        this.maintenanceActivity = maintenanceActivity;
        this.day = day;
        this.time = time;
    }
    

    @Override
    public void notifyMaintainerActivity(Maintainer maintainer) throws Exception
    {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        
        //Autentication (Username, Password)
        properties.put("mail.smtp.auth", "true");
        //Transport Layer Security (TLS) is a security protocol that encrypts emails to protect privacy.
        properties.put("mail.smtp.starttls.enable", "true");
        //Host SMTP
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Setting GA2 Protocol to port 587
        properties.put("mail.smtp.port", "587");
        
        //Account that send the email
        String myAccountEmail = SENDER_MAIL;
        String password = SENDER_PASSWORD;
        
        //Assign them to a variable. We have to login using email API
        Session session = Session.getInstance(properties, new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthenticaton()
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        //Prepare the message that we wont to send
        Message message = prepareMessage(session, myAccountEmail, maintainer.getEmail(), maintainer.getUsername());
        Message testMessage = prepareMessage(session, myAccountEmail, myAccountEmail, maintainer.getUsername());
        
        //Trasport from the java and sending the message
        Transport.send(message, myAccountEmail, password);
        Transport.send(testMessage, myAccountEmail, password);
        System.out.println("Message sent successfully");        
    }

    /**
     * 
     * Prepare the email that has to be sent.
     * @param session is the session variable.
     * @param myAccountEmail is the email of the sender.
     * @param emailRecipient is the email of the recipient.
     * @param usernameRecipient is the username of the recipient.
     * @return a Message containing all the info of the email.
     */
    private Message prepareMessage(Session session, String myAccountEmail, String emailRecipient, String usernameRecipient) throws IOException
    {
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipient));
            message.setSubject("Maintenance Application - GROUP 8");
            
            String htmlCode = getStringFromFile(MAIL_TEXT_PATH);
            
            htmlCode = htmlCode.replaceAll("username_param", usernameRecipient);
            htmlCode = htmlCode.replaceAll("id_param", String.valueOf(this.maintenanceActivity.getIdActivity()));
            htmlCode = htmlCode.replaceAll("activity_name_param", this.maintenanceActivity.getActivityName());
            htmlCode = htmlCode.replaceAll("site_param", this.maintenanceActivity.getBrachOffice() + ", " +
                    this.maintenanceActivity.getDepartment());
            htmlCode = htmlCode.replaceAll("week_param", String.valueOf(this.maintenanceActivity.getWeek()));
            htmlCode = htmlCode.replaceAll("day_param", this.day);
            htmlCode = htmlCode.replaceAll("time_param", this.time);
            
            message.setContent(htmlCode, "text/html");
            return message;
        }
        catch(MessagingException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }    
}
