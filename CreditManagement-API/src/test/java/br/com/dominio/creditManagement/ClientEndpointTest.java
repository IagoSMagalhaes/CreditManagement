package br.com.dominio.creditManagement;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dominio.creditManagement.enums.RiskEnum;
import br.com.dominio.creditManagement.model.ClientModel;
import br.com.dominio.creditManagement.repository.ClientRepository;

/**
 * @author iagoMagalhaes
 *Class responsible test ClientModelEndPoint
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientEndpointTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	@MockBean
	private ClientRepository clientRepository;
	
	@Test
	public void getClientModelByIdWhenIdNotLongReturnStatus401()throws Exception  {
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/{id}", ClientModel.class, "1");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(401);	
	}
	@Test
	public void getClientModelByIdWhenIdWhenCorrectShouldTypeReturnStatus200()throws Exception  {
		ClientModel clientModel = new ClientModel("1", "Iago", 2500L, RiskEnum.B, RiskEnum.B.getTaxa());
		clientRepository.save(clientModel);
		BDDMockito.when(clientRepository.findById("1")).equals(clientModel);		
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/{id}", ClientModel.class, "1");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	
	@Test
	public void listAllClientModelWhenCorrectTypeShouldReturnStatus200() throws Exception  {
		List<ClientModel> users = new ArrayList<>();
		ClientModel client = new ClientModel("1", "Iago", 2500L, RiskEnum.B, RiskEnum.B.getTaxa());
		ClientModel clientTwo = new ClientModel("2", "Iago", 2500L, RiskEnum.B, RiskEnum.B.getTaxa());
		users.add(client);
		users.add(clientTwo);
		
		BDDMockito.when(clientRepository.findAll()).thenReturn(users);
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/", ClientModel.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	@Test
	public void getClientModelByIdWhenIdClientModelNotExistShouldReturnStatus404() throws Exception {		 
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/id}", ClientModel.class, "123456789");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);	
	} 
	
	@Test
	public void deleteClientModelByIdWhenIdClientModelNotExistShouldReturnStatus404() throws Exception {
		
		clientRepository.save(new ClientModel("1", "Iago", 2500L, RiskEnum.B, RiskEnum.B.getTaxa()));		
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/deleteById/{id}", ClientModel.class, "123456789");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	@Test
	public void deleteClientModelByIdCorrectShouldReturnStatusCode204() throws Exception {
		
		clientRepository.save(new ClientModel("1", "Iago", 2500L, RiskEnum.B, RiskEnum.B.getTaxa()));	
		BDDMockito.doNothing().when(clientRepository).deleteById("1");
		ResponseEntity<ClientModel> response = restTemplate.getForEntity("/clients/{id}", ClientModel.class, "1");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(204);	
	}
	
	@Test
	public void createClientModelWhenNameIsNullCorrectShouldReturnStatus422() throws Exception {
		
		ClientModel client = new ClientModel("1", null, 2500L, RiskEnum.B, RiskEnum.B.getTaxa());
		clientRepository.save(client);
		ResponseEntity<ClientModel> response = restTemplate.postForEntity("/clients/{client}", client, ClientModel.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(422);	
	}
	
	@Test
	public void createClientModelWhenCreditLimitIsNullShouldReturnStatus422() throws Exception {
		ClientModel user = new ClientModel("1", "Iago", null, RiskEnum.B, RiskEnum.B.getTaxa());		
		clientRepository.save(user);
		ResponseEntity<ClientModel> response = restTemplate.postForEntity("/clients/{client}", user, ClientModel.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(422);	
	}
	
	@Test
	public void createClientModelWhenRiskIsNullShouldReturnStatus422() throws Exception {
		ClientModel user = new ClientModel("1", "Iago", 2500L, null, RiskEnum.B.getTaxa());
		clientRepository.save(user);
		ResponseEntity<ClientModel> response = restTemplate.postForEntity("/clients/save/{client}", user, ClientModel.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
}
