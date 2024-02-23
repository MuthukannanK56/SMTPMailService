package com.example.SMTPMailService;

public interface EmailService {

    String sendSimpleEmail(EmailDetails emailDetails);

    String sendMailWithAttachment(EmailDetails emailDetails);


}
