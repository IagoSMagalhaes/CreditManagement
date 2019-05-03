package br.com.dominio.creditManagement.infra.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class JsonConfig extends WebMvcConfigurerAdapter {
//
	@Bean
	public ObjectMapper objectMapper() {

		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);	
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}
	
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	        .allowedOrigins("http://localhost:4200")
            .allowedMethods("PUT", "DELETE", "GET", "POST");
	    }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
	        configurer.enable();
	}
}