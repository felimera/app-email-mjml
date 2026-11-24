package com.project.app_email_mjml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AppEmailMjmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEmailMjmlApplication.class, args);
	}

}
