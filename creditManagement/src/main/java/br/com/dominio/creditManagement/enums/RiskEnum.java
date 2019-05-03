package br.com.dominio.creditManagement.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RiskEnum {
	@JsonProperty("A")
	A("A", 0L),
	@JsonProperty("B")
	B("B", 10L),
	@JsonProperty("C")
	C("C", 20L);
	
	@Getter
	private String codigo;
	
	@Getter
	private Long taxa;

}
