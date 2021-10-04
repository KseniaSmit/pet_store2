package com.mirea.petshop.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Класс-сервис для отправки сообщений на электронную почту
 * @author Сметанникова Ксения
 */
@Service
@Transactional
public class EmailService {
    /**
     * Асинхронный метод отправки сообщения на почту
     * @param email  Адрес электронной почты
     * @param message Сообщение
     * @throws AddressException Исключение, возникающее при обнаружении неправильно отформатированного адреса
     * @throws MessagingException Базовый класс для всех исключений, создаваемых классами обмена сообщениями
     * @throws IOException Сигнализирует о том, что произошло какое-либо исключение ввода-вывода. Этот класс является общим классом исключений, создаваемых неудачными или прерванными операциями ввода-вывода.
     */
    @Async
    public void sendmail(String message, String email) throws AddressException, MessagingException, IOException{
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smetannikov44ksenia@gmail.com", "89536698270");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("smetannikov44ksenia@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Создание заказа");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Ваш заказ {" + message + '}' + " успешно создан", "text/html; charset=UTF-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}

