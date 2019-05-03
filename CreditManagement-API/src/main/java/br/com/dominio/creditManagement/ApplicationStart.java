package br.com.dominio.creditManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Iago Magalhães 25/04/2019 System execution class with its proper
 *         annotations
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.dominio.creditManagement"})
@EnableJpaRepositories(basePackages = "br.com.dominio")
@EntityScan("br.com.dominio")
@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class })
public class ApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
