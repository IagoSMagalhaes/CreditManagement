package br.com.dominio.creditManagement.infra.converter;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import br.com.dominio.creditManagement.infra.json.Json;


public interface ModelToJsonConverter <T extends Serializable, K extends Json> {
	
	K convertToJson(Optional<T> model);

	public default K toJson(Optional<T> model) {

		if(model != null) {
			return this.convertToJson(model);
		}

		return null;
	}
	
	public default List<K> toListJson(Iterable<T> models) {
		final List<K> jsons = Lists.newArrayList();
			models.forEach(model -> jsons.add(toJson(Optional.ofNullable(model))));
			return jsons;
	}
	
}
