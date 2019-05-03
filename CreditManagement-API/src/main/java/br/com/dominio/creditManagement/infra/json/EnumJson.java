package br.com.dominio.creditManagement.infra.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnumJson {

	@JsonProperty("id")
	private String id;

	@JsonProperty("descricao")
	private String descricao;

	public static EnumJson of(final String id) {
		return new EnumJson(id, null);
	}

}
