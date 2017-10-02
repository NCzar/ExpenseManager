/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author nikhilv85
 */
public class Javamail {
    String user;
    int index;
  String userid;
  String emailaddress;
     
    
   // private static String userid = "nikhilv85";
  /*
   String USER_NAME = "jyteamusa";  // GMail user name (just the part before "@gmail.com")
   String PASSWORD = "sacrament12"; // GMail password
  */
 // String USER_NAME = "inspiredlivingexp";  // GMail user name (just the part before "@gmail.com")
  String USER_NAME = "test@docuwind.awsapps.com";
  String PASSWORD = "Inspired1";
  static final String SMTP_USERNAME = "AKIAISR65BY3BQKEQ2ZQ";  // Replace with your SMTP username.
    static final String SMTP_PASSWORD = "AiQbh+IuB4a+FWLYPvMaj6BT6FU3oUvjve/jPL0ISvpu";
   //String RECIPIENT = "nikhilv85@gmail.com";
    String RECIPIENT = "";
    public static void main(String args[]) {
       Javamail sa= new Javamail();
       String text,email;
       text="hi";
       email="nikhilvar85@gmail.com";
       sa.sendmailwithsubject(email, text, "Introducing me");
    }
        
    void sendmail(String text,String email){
         
         String from = USER_NAME;
        String pass = PASSWORD;
        
            System.out.println(RECIPIENT);
             System.out.println(emailaddress);
             System.out.println(userid);
        //RECIPIENT = emailaddress.concat(RECIPIENT);
          RECIPIENT = email;   
        System.out.println(RECIPIENT);
        String[] to = { RECIPIENT }; // list of recipient email addresses
       
        
        String subject = "InspiredLiving";
        String body = text;
        
        
    Properties props = System.getProperties();
    
    /*
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
*/
    
    //begin trial
    
    String host = "email-smtp.us-east-1.amazonaws.com";
       props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    
    //end trial
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            //toAddress[0]=new InternetAddress(emailaddress);
            for( int i = 0; i < toAddress.length; i++) {
                
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            
            
           
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    void sendmailwithsubject(String email,String text,String subject){
         
         String from = USER_NAME;
        String pass = PASSWORD;
            
            RECIPIENT = email;   
       
        String[] to = { RECIPIENT }; // list of recipient email addresses
       
        String body = text;
               
    Properties props = System.getProperties();
       
    String host = "email-smtp.us-east-1.amazonaws.com";
       props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
          
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
                       
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    }

