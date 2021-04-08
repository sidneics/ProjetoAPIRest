package br.com.cotiinformatica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Principal classe de configuração do projeto
 * Nesta classe iremos mapear todo o caminho de pacotes do projeto
 */

@SpringBootApplication(scanBasePackages = { "br.com.cotiinformatica" })
public class ProjetoSpringApi01Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApi01Application.class, args);
	}

}
