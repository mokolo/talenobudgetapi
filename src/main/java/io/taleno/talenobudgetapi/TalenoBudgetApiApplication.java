package io.taleno.talenobudgetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TalenoBudgetApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(TalenoBudgetApiApplication.class, args);
	}

}
