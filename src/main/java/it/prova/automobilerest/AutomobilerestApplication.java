package it.prova.automobilerest;

import it.prova.automobilerest.model.Automobile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomobilerestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomobilerestApplication.class, args);
		Automobile a = new Automobile();

	}

}
