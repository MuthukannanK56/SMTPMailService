package com.example.SMTPMailService;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.*;
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username")
    private String sender;

    public String sendSimpleEmail(EmailDetails emailDetails){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.sender);
        simpleMailMessage.setTo(emailDetails.getRecipient());
        simpleMailMessage.setText(emailDetails.getMessage());
        simpleMailMessage.setSubject(emailDetails.getSubject());
        this.javaMailSender.send(simpleMailMessage);

        return "Mail Send Successfully";
    }



    public String sendMailWithAttachment(EmailDetails emailDetails){

        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(this.sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getMessage());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
           FileSystemResource fileSystemResource = new FileSystemResource(emailDetails.getAttachment());
           mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            this.javaMailSender.send(mimeMessage);
            return "Mail send with Attachment.";
        }
        catch (MessagingException var5){
            return "Error while sending mail!!!";
        }

    }




}
