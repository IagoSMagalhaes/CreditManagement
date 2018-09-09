package br.com.dominio.gerenciamentoEndereco.br.com.dominio.gerenciamentoEndereco;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author iagom
 *	System execution class with its proper annotations
 */
@SpringBootApplication
@ComponentScan(basePackages = {"endpoint", "model", "util", "repository", "docs"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan("model")
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
 