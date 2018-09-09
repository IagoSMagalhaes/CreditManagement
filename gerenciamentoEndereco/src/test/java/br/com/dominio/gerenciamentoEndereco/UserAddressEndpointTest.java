package br.com.dominio.gerenciamentoEndereco;

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

import model.UserAddress;
import repository.UserAddressRepository;

/**
 * @author iagoMagalhaes
 *Class responsible test UserAddressEndPoint
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserAddressEndpointTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	@MockBean
	private UserAddressRepository userAddressRepository;
	
	@Test
	public void getUserByIdWhenIdNotLongReturnStatus401()throws Exception  {
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/{id}", UserAddress.class, "s");
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(401);	
	}
	@Test
	public void getUserByIdWhenIdWhenCorrectShouldTypeReturnStatus200()throws Exception  {
		
		userAddressRepository.save(new UserAddress(1L));
		BDDMockito.when(userAddressRepository.findById(new UserAddress(1L).getId())).equals(new UserAddress(1L));		
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/{id}", UserAddress.class, 1L);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	
	@Test
	public void listAllUserAddressWhenCorrectTypeShouldReturnStatus200() throws Exception  {
		List<UserAddress> users = new ArrayList<>();
		UserAddress user1 = new UserAddress(1L);
		UserAddress user2 = new UserAddress(2L);
		users.add(user1);
		users.add(user2);
		
		BDDMockito.when(userAddressRepository.findAll()).thenReturn(users);
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/listAll", UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	@Test
	public void getUserAddressByIdWhenIdUserAddressNotExistShouldReturnStatus404() throws Exception {		 
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/findById/{id}", UserAddress.class, -1);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(404);	
	} 
	
	@Test
	public void deleteUserAddressByIdWhenIdUserAddressNotExistShouldReturnStatus404() throws Exception {
		
		userAddressRepository.save(new UserAddress(1L));		
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/deleteById/{id}", UserAddress.class, -1);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	
	@Test
	public void deleteUserAddressByIdCorrectShouldReturnStatusCode200() throws Exception {
		
		userAddressRepository.save(new UserAddress(1L));		
		BDDMockito.doNothing().when(userAddressRepository).deleteById(1L);
		ResponseEntity<UserAddress> response = restTemplate.getForEntity("/usersAddress/deleteById/{id}", UserAddress.class, 1);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	
	@Test
	public void createUserAddressWheCorrectShouldReturnStatus200() throws Exception {
		
//		userRepository.save(new User(1L, "user"));
		UserAddress userAddress = new UserAddress(1L,"SP","Sao Paulo", "Santana", "Avenida Braz leme", "99", null, "0000000");
		userAddressRepository.save(userAddress);
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);	
	}
	
	@Test
	public void createUserAddressWhenStreetIsNullShouldReturnStatus400() throws Exception {
//		userRepository.save(new User(1L, "user"));
		
		UserAddress userAddress = new UserAddress(1L,"SP","Sao Paulo", "Santana", null, "99", null, "0000000");		
		userAddressRepository.save(userAddress);
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	@Test
	public void createUserAddressWhenCityIsNullShouldReturnStatus400() throws Exception {
//		userRepository.save(new User(1L, "user"));
		UserAddress userAddress = new UserAddress(1L,"SP",null, "Santana", "Avenida Braz leme", "99", null, "0000000");		
		userAddressRepository.save(userAddress);
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	@Test
	public void createUserAddressWhenStadeIsNullShouldReturnStatus400() throws Exception {
//		userRepository.save(new User(1L, "user"));
		UserAddress userAddress = new UserAddress(1L,"SP","Sao Paulo", "Santana", "Avenida Braz leme", "99", null, "0000000");
		userAddressRepository.save(userAddress);
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	@Test
	public void createUserAddressWhenNumberIsNullShouldReturnStatus400() throws Exception {
//		userRepository.save(new User(1L, "user"));
		UserAddress userAddress = new UserAddress(1L,"SP","Sao Paulo", "Santana", "Avenida Braz leme", "99", null, "0000000");
		BDDMockito.when(userAddressRepository.save(userAddress)).thenReturn(userAddress);
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	@Test
	public void createUserAddressWhenCepIsNullShouldReturnStatus400() throws Exception {
//		userRepository.save(new User(1L, "user"));
		UserAddress userAddress = new UserAddress(1L,"SP","Sao Paulo", "Santana", "Avenida Braz leme", "99", null, "0000000");
		BDDMockito.when(userAddressRepository.save(userAddress)).thenReturn(userAddress);		
		ResponseEntity<UserAddress> response = restTemplate.postForEntity("/usersAddress/save/{user}", userAddress, UserAddress.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(400);	
	}
	
	
	
	
	
	
}
