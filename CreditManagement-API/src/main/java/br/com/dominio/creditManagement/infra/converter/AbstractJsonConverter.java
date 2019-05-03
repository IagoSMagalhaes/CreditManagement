package br.com.dominio.creditManagement.infra.converter;

import java.io.Serializable;

import br.com.dominio.creditManagement.infra.json.Json;

public abstract class AbstractJsonConverter<T extends Serializable, K extends Json> 
							implements JsonConverter<T, K> {

}
	