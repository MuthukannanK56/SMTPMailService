package com.example.SMTPMailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SmtpMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmtpMailServiceApplication.class, args);
	}

}
