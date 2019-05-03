package br.com.dominio.creditManagement.infra.converter;

import static java.lang.Enum.valueOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import br.com.dominio.creditManagement.infra.json.EnumJson;
import lombok.Getter;

@Component
public class EnumJsonConverter {
	
	@Getter
	@Autowired
	private MessageSource messageSource;
	
	public EnumJson toEnumJson(final Enum<?> valor) {
		if (valor == null) {
			return null;
		}
		return new EnumJson(valor.name(), getMessage(valor));
	}
	
	public String getMessage(final Enum<?> valor) {
		return valor.getClass().getName() + "." + valor.name();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Enum> T toEnum(final EnumJson enumJson, final Class<T> clazz) {

        if (enumJson != null) {
            return (T) valueOf(clazz, enumJson.getId());
        }

        return null;
    }

}
