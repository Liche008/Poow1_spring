package br.csi.projetoacademia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProjetoAcademiaSpringApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProjetoAcademiaSpringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAcademiaSpringApplication.class, args);
	}
}
