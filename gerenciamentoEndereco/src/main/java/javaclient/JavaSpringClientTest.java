package javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestResult;
import model.UserAddress;

public class JavaSpringClientTest {
	/**
	 * Specie the main SpringBoot for Test
	 */
	public static void main (String[] args) {
		
		
		RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/users").build();
		
		ResponseEntity<UserAddress> usuario = restTemplate.getForEntity("/{id}", UserAddress.class, 5);
		
		UserAddress[] usuarios = restTemplate.getForObject("/listAll", UserAddress[].class);
		ResponseEntity<List<UserAddress>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserAddress>>() {});		
		System.out.println(exchange.getBody());
	}
	
}
