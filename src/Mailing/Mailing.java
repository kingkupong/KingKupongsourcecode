/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mailing;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Boomeraling
 */
public class Mailing {

    // Atributos
    private static Properties properties;
    private static Session session;
    private static final String user = "kingkupong@gmail.com";
    private static final String pass = "Boom1234";

    public Mailing() {

    }

    private static void enviarMail(String to, String subject, String body) {

        setProperties(user, pass);
        setSession();

        try {
            // MimeMessage object
            MimeMessage message = new MimeMessage(session);
            // Set To
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject
            message.setSubject(subject);
            // Message body
            message.setText(body);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public static void enviarMailBienvenida(String to) {
        String subject = "El equipo de King Kupong le da la bienvenida.";
        String body = "Muchas gracias por su registro en nuestra página super-web.";
        enviarMail(to, subject, body);
    }

    public static void enviarMailGenerico(String to, String body, String subject) {
        enviarMail(to, subject, body);
    }

    /**
     * Método que define los parámetros de configuración para el servidor de
     * correo
     */
    private static void setProperties(String user, String pass) {

        // Instanciamos la clase Properties     
        properties = new Properties();
        // Nombre del host de correo
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        //tls (transport layer Security) protocolo criptográfico en comunicaciones seguras de red
        properties.setProperty("mail.smtp.starttls.enable", "true");
        // Asignamos el puerto de gmail para envio de correos
        properties.setProperty("mail.smtp.port", "587");
        // Si requiere usuario y password para conectarse.
        properties.setProperty("mail.smtp.auth", "true");
        // Usuario y password
        properties.setProperty("mail.user", user);
        properties.setProperty("mail.password", pass);

    }

    private static void setSession() {
        session = Session.getInstance(properties, new Mailing.SocialAuth(user, pass));
    }

    private static class SocialAuth extends Authenticator {

        private final String user;
        private final String pass;

        public SocialAuth(String user, String pass) {
            this.user = user;
            this.pass = pass;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, pass);
        }
    }

}
