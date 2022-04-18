package br.edu.univas.si7.prova01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Prova01Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Prova01Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
