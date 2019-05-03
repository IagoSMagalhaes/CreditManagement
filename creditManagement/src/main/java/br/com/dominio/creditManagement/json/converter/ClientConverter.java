package br.com.dominio.creditManagement.json.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dominio.creditManagement.enums.RiskEnum;
import br.com.dominio.creditManagement.infra.converter.AbstractJsonConverter;
import br.com.dominio.creditManagement.infra.converter.EnumJsonConverter;
import br.com.dominio.creditManagement.infra.json.EnumJson;
import br.com.dominio.creditManagement.json.model.ClientJson;
import br.com.dominio.creditManagement.model.ClientModel;

@Service
public class ClientConverter extends AbstractJsonConverter<ClientModel, ClientJson> {
	
	@Autowired
	private EnumJsonConverter enumJsonConverter;

	@Override
	public ClientModel convertToModel(ClientJson json) {
		if (json == null) {
			return null;
		}
		RiskEnum riskEnum = this.enumJsonConverter.toEnum(json.getRisk(), RiskEnum.class);
		return new ClientModel(json.getId(), json.getName(), json.getCreditLimit(), riskEnum,  riskEnum.getTaxa());
	}

	@Override
	public ClientJson convertToJson(Optional<ClientModel> model) {
		if (model.isPresent()) {
			EnumJson riskEnum = this.enumJsonConverter.toEnumJson(model.get().getRisk());
			return new ClientJson(model.get().getId(), model.get().getName(), model.get().getCreditLimit(), riskEnum, model.get().getRisk().getTaxa());
		}
		return null;
	}
}
