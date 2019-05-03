package br.com.dominio.creditManagement.infra.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationErrorDetails {
	
	
	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;
	private String field;
	private String fieldMessage;

}
