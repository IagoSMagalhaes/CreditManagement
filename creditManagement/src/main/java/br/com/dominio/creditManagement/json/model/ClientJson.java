package br.com.dominio.creditManagement.json.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.dominio.creditManagement.enums.RiskEnum;
import br.com.dominio.creditManagement.infra.json.AbstractModelJson;
import br.com.dominio.creditManagement.infra.json.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientJson extends AbstractModelJson {
/**
	 * 
	 */
	private static final long serialVersionUID = -5827331229681816137L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("creditLimit")
	private Long creditLimit;
	
	@JsonProperty("risk")
	private EnumJson risk;
//	
	@JsonProperty("interestRate")
	private Long interestRate;
}
