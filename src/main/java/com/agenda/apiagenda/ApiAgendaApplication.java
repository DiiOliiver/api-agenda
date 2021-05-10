package com.agenda.apiagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ApiAgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgendaApplication.class, args);
	}

}
