package br.com.dominio.creditManagement.endpoint;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dominio.creditManagement.infra.controller.BaseController;
import br.com.dominio.creditManagement.json.converter.ClientConverter;
import br.com.dominio.creditManagement.json.model.ClientJson;
import br.com.dominio.creditManagement.model.ClientModel;
import br.com.dominio.creditManagement.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author iagoMagalhães
 * RestController responsible for the Client Model
 * @param <T>
 */
@RestController
@RequestMapping(ClientController.URI)
@Api(tags = "ClientController")
public class ClientController extends BaseController {
	
	public static final String URI = "/api/v1/clients";
	
	@Autowired
	ClientRepository clientRepository;
		
	@Autowired
	ClientConverter clientConverter;
	
	@GetMapping( value = "/", produces = {APPLICATION_JSON_VALUE})
	@ApiOperation(value = "List all list client")
	public ResponseEntity<List<ClientJson>> listAll(){
		List<ClientJson> clients = clientConverter.toListJson(clientRepository.findAll());
		return this.ok(clients);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = {APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Return client searching by Id" , response = ClientJson.class)
	public ResponseEntity<?> get(@PathVariable("id") String id){
		ClientJson client = clientConverter.convertToJson(clientRepository.findById(id));
		return this.ok(client); 
	}

	@PostMapping(path = "/", produces = {APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Save client request Body" , response = Void.class)
	public ResponseEntity<Void> save(@RequestBody ClientJson json){
		final ClientModel client =  clientConverter.toModel(json);
		clientRepository.save(client);
		return this.created();
	
	}
	@DeleteMapping(path="/{id}")
	@ApiOperation(value = "Delete client by Id" , response = Void.class)
	public ResponseEntity<Void> delete(@PathVariable String id){
		clientRepository.deleteById(id);
		return this.noContent();
	}
	
	@PutMapping(path="/")
	@ApiOperation(value = "Update client" , response = String.class)
	public ResponseEntity<Void> doUpdate(@RequestBody ClientJson json){
		final ClientModel client =  clientConverter.toModel(json);
		clientRepository.save(client);
		return this.ok();
	}
}
