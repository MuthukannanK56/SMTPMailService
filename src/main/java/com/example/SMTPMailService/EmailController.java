package com.example.SMTPMailService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {


    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        String status = emailService.sendSimpleEmail(emailDetails);
        return status;
    }

    @PostMapping("/sendwithattachment")
    public String sendWithAttachemnt(@RequestBody EmailDetails emailDetails){
        String status = emailService.sendMailWithAttachment(emailDetails);
        return status;
    }



}
