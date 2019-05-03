package br.com.dominio.creditManagement.infra.converter;

import java.io.Serializable;

import br.com.dominio.creditManagement.infra.json.Json;

public interface JsonConverter <T extends Serializable, K extends Json> 
					extends JsonToModelConverter<T, K>,
					        ModelToJsonConverter<T, K> {

}
