package br.com.dominio.creditManagement.infra.converter;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.dominio.creditManagement.infra.json.Json;

public interface JsonToModelConverter <T extends Serializable, K extends Json> {

	T convertToModel(K json);

	public default T toModel(K json) {

		if(json != null) {
			return this.convertToModel(json);
		}

		return null;
	}
	
	public default List<T> toListModel(Collection<K> jsons) {

		if(jsons.isEmpty()) {
			final List<T> models = Lists.newArrayList();
			jsons.stream().forEach(json -> models.add(toModel(json)));
			return models;
		}

		return null;
	}
}
